package dao;

import mybeans.Users;
import myutils.JdbcUtils;
import myutils.MyMD5;

import java.sql.*;

public class UsersDao {
    //登录验证及用户存在
    public int queryUser(String username, String password, String identCode) {
        Connection conn = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        int result=0;
        try {
            String sql = "select * from users where username=?";
            conn = JdbcUtils.getConnection();
            pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, username);

            rs = pStmt.executeQuery();

            if (rs.next()) {
                String pwd = rs.getString("password");
                String salt = rs.getString("identCode");
                if (MyMD5.verify(password, salt, pwd)) {
                    //验证成功
                   result=2;
                } else {
                    //密码错误
                    result= 1;
                }
            } else {
                //用户不存在
               result= 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            //服务器异常
            result= -2;
        } finally {
            JdbcUtils.closeRes(conn, pStmt, rs);
        }
    return  result;
    }

    //注册用户是添加users的信息
    public int addUser(Users user) {
        Connection conn = null;
        PreparedStatement pStmt = null;
        int cnt=0;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into users values(null,?,?,?)";
            pStmt = conn.prepareStatement(sql);

            pStmt.setString(1, user.getUsername());
            pStmt.setString(2, MyMD5.md5(user.getPassword(), user.getIdentCode()));
            pStmt.setString(3, user.getIdentCode());


            cnt = pStmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            cnt= -2;
        } finally {

            try {
                if(pStmt!=null) {
                    pStmt.close();
                }
                if(conn!=null) {
                    conn.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return cnt;
    }

    //修改用户的密码和认证码，用于找回密码功能
    public int updatePwd(Users user){
        Connection conn = null;
        PreparedStatement pStmt = null;
        int cnt=0;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "update users set  password=? and identcode=? where username=?";
            pStmt = conn.prepareStatement(sql);


            pStmt.setString(1, MyMD5.md5(user.getPassword(), user.getIdentCode()));
            pStmt.setString(2, user.getIdentCode());
            pStmt.setString(3, user.getUsername());

            cnt = pStmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            cnt= -2;
        } finally {
            JdbcUtils.closeRes(conn, pStmt, null);
        }
        return cnt;
    }


    //删除用户，需要先删除其他相关联的表
    public int deleteUser(String usernsme){
        Connection conn = null;
        PreparedStatement pStmt = null;
        int cnt=0;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "delete users where username=?";

            pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,usernsme);
            cnt = pStmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            cnt= -2;
        } finally {
            JdbcUtils.closeRes(conn, pStmt, null);

        }
        return cnt;
    }


}
