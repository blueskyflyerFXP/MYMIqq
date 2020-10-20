package dao;

import mybeans.FriendsInfo;
import myutils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FriendInfoDao {

    //加好友
    public int addFriend(FriendsInfo frsinfo) {
        Connection conn = null;
        PreparedStatement pStmt = null;
        int cnt=0;
        try {
            conn = JdbcUtils.getConnection();
            String sql1 = "insert into users values(null,?,?,?,?)";
            pStmt = conn.prepareStatement(sql1);

            pStmt.setString(1, frsinfo.getMyself());
            pStmt.setString(2, frsinfo.getFriend());
            pStmt.setString(3, frsinfo.getRemark());
            pStmt.setDate(4, (java.sql.Date) frsinfo.getShipTime());


            cnt = pStmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            cnt=-2;
        } finally {
            JdbcUtils.closeRes(conn, pStmt, null);
        }
        return cnt;
    }
    //修改好友备注
    public int updateFriend(FriendsInfo frsinfo) {
        Connection conn = null;
        PreparedStatement pStmt = null;
        int cnt=0;
        try {
            conn = JdbcUtils.getConnection();
            String sql1 = "update friendinfo set remark=? where myself=? and friend=?";
            pStmt = conn.prepareStatement(sql1);

            pStmt.setString(1, frsinfo.getRemark());
            pStmt.setString(2, frsinfo.getMyself());
            pStmt.setString(3, frsinfo.getFriend());
            cnt = pStmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            cnt=-2;
        } finally {
            JdbcUtils.closeRes(conn, pStmt, null);
        }
        return cnt;
    }
    //删除好友
    public int deleteFriend(String you,String yourfriend) {
        Connection conn = null;
        PreparedStatement pStmt = null;
        int cnt=0;
        try {
            conn = JdbcUtils.getConnection();
            String sql1 = "delete friendinfo where myself=? and friend=?";
            pStmt = conn.prepareStatement(sql1);

            pStmt.setString(1, you);
            pStmt.setString(2, yourfriend);
            int cnt1 = pStmt.executeUpdate();

            String sql2 = "delete friendinfo where myself=? and friend=?";
            pStmt = conn.prepareStatement(sql2);

            pStmt.setString(1, yourfriend);
            pStmt.setString(2, you);
            int cnt2=pStmt.executeUpdate();
            cnt=cnt1+cnt2;
        } catch (Exception e) {
            e.printStackTrace();
            cnt=-2;
        } finally {
            JdbcUtils.closeRes(conn, pStmt, null);
        }
        return cnt;
    }

    //查询好友，返回好友列表
    public ArrayList<String> queryFriend(String user) {
        ArrayList<String> friendList=new ArrayList<>();
        Connection conn = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from friendinfo where myself=? or friend=?";
            conn = JdbcUtils.getConnection();
            pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, user);
            pStmt.setString(2, user);

            rs = pStmt.executeQuery();

            while (rs.next()) {
                friendList.add(rs.getString("friend"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            //服务器异常
            friendList=null;
        } finally {
            JdbcUtils.closeRes(conn, pStmt, rs);
        }
        return friendList;
    }
}
