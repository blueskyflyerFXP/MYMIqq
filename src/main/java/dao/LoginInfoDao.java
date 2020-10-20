package dao;

import mybeans.LoginInfo;
import myutils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginInfoDao {
    //注册用户是添加users的登录信息LoginInfo
    public int addUser(LoginInfo logininfo) {
        deleteLoginInfo(logininfo.getUsername());
        Connection conn = null;
        PreparedStatement pStmt = null;
        int cnt=0;
        try {
            conn = JdbcUtils.getConnection();
            String sql1 = "insert into logininfo values(?,?,?,?)";
            pStmt = conn.prepareStatement(sql1);

            pStmt.setString(1, logininfo.getUsername());
            pStmt.setString(2, logininfo.getUserIp());
            pStmt.setBoolean(3, logininfo.getOnlineState());
            pStmt.setDate(4, (java.sql.Date) logininfo.getLoginTime());


            cnt = pStmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return -2;
        } finally {
            JdbcUtils.closeRes(conn, pStmt, null);

        }
        return cnt;
    }
    //查询用户的登录信息
    public LoginInfo queryLogin(String username) {
        Connection conn = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        LoginInfo login=new LoginInfo();
        int result=0;
        try {
            String sql = "select * from logininfo where username=?";
            conn = JdbcUtils.getConnection();
            pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, username);

            rs = pStmt.executeQuery();

            login.setUsername(rs.getString("username"));
            login.setLoginTime(rs.getDate("logintime"));
            login.setOnlineState(rs.getBoolean("onlinestate"));
            login.setUserIp(rs.getString("userip"));

        } catch (Exception e) {
            e.printStackTrace();
            //服务器异常
            login=null;
        } finally {
            JdbcUtils.closeRes(conn, pStmt, rs);
        }
        return  login;
    }

    //删除旧的用户登录信息
    public int deleteLoginInfo(String usernsme){
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
