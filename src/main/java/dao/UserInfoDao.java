package dao;

import mybeans.UserInfo;
import myutils.JdbcUtils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserInfoDao {
    //注册时添加用户资料
    public int addUserInfo(UserInfo userinfo) {
        Connection conn = null;
        PreparedStatement pStmt = null;
        int cnt=0;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into userinfo values(?,?,?,?,?,?,?,?,?,?)";
            pStmt = conn.prepareStatement(sql);

            pStmt.setString(1, userinfo.getUsername());
            pStmt.setString(2, userinfo.getNickname());
            pStmt.setBytes(3, userinfo.getProtraitPicture());
            pStmt.setString(4, userinfo.getSex());
            pStmt.setString(5, userinfo.getSignature());
            pStmt.setString(6, userinfo.getLocale());
            pStmt.setDate(7, (Date) userinfo.getBirthday());
            pStmt.setInt(8, userinfo.getTelephone());
            pStmt.setString(9, userinfo.getHobby());
            pStmt.setString(10, userinfo.getEmail());

            cnt = pStmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {

            JdbcUtils.closeRes(conn, pStmt, null);
        }
        return cnt;
    }

    //根据用户名查询用户资料
    public ArrayList<UserInfo> queryUserInfo(String username){
        ArrayList<UserInfo> userInfos=new ArrayList<>();
        Connection conn = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from users where username=?";
            conn = JdbcUtils.getConnection();
            pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, username);

            rs = pStmt.executeQuery();

            if (rs.next()) {
                UserInfo userinfo=new UserInfo();
                userinfo.setUsername(rs.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            //服务器异常
            userInfos=null;
        } finally {
            JdbcUtils.closeRes(conn, pStmt, rs);
        }
        return userInfos;
    }

    //修改用户资料
    public int updateUserInfo(UserInfo userinfo){
        Connection conn = null;
        PreparedStatement pStmt = null;
        int cnt=0;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "update users set nickname=? and protraitpicture=? and sex=? and signture=? and " +
                    "locale=? and birthday=? and telephone=? and hobby=? and email=? where username=?";
            pStmt = conn.prepareStatement(sql);



            pStmt.setString(1, userinfo.getNickname());
            pStmt.setBytes(2, userinfo.getProtraitPicture());
            pStmt.setString(3, userinfo.getSex());
            pStmt.setString(4, userinfo.getSignature());
            pStmt.setString(5, userinfo.getLocale());
            pStmt.setDate(6, (Date) userinfo.getBirthday());
            pStmt.setInt(7, userinfo.getTelephone());
            pStmt.setString(8, userinfo.getHobby());
            pStmt.setString(9, userinfo.getEmail());
            pStmt.setString(10, userinfo.getUsername());

            cnt = pStmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return -2;
        } finally {
            JdbcUtils.closeRes(conn, pStmt, null);

        }
        return cnt;
    }

    //删除用户资料
    public int deleteUser(String username){
        Connection conn = null;
        PreparedStatement pStmt = null;
        int cnt=0;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "delete userinfo where username=?";
            pStmt = conn.prepareStatement(sql);

            pStmt.setString(1, username);

            cnt = pStmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            cnt=-2;
        } finally {
            JdbcUtils.closeRes(conn, pStmt, null);

        }
        return cnt;
    }


}
