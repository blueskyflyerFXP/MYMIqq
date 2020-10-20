package dao;

import mybeans.GroupsInfo;

import myutils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GroupInfoDao {

    //根据群成员查询所加的群组列表
    public ArrayList<String> queryGroups(String groupMember) {
        Connection conn = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        ArrayList<String> groupList = new ArrayList<>();
        try {
            String sql = "select * from users where yourself=?";
            conn = JdbcUtils.getConnection();
            pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, groupMember);

            rs = pStmt.executeQuery();

            while (rs.next()) {
                groupList.add(rs.getString("group"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            //服务器异常
            return null;
        } finally {
            JdbcUtils.closeRes(conn, pStmt, rs);
        }
        return groupList;
    }

    //根据群名称查询群成员
    public ArrayList<String> queryUsers(String groupname) {
        Connection conn = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        ArrayList<String> groupList = new ArrayList<>();
        try {
            String sql = "select * from users where group=?";
            conn = JdbcUtils.getConnection();
            pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, groupname);

            rs = pStmt.executeQuery();

            while (rs.next()) {
                groupList.add(rs.getString("yourself"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            //服务器异常
            return null;
        } finally {
            JdbcUtils.closeRes(conn, pStmt, rs);
        }
        return groupList;
    }

    //增加群资料
    public int addGroupInfo(GroupsInfo groups) {
        Connection conn = null;
        PreparedStatement pStmt = null;
        int cnt=0;
        try {
            conn = JdbcUtils.getConnection();
            String sql1 = "insert into groupsinfo values(null,?,?,?)";
            pStmt = conn.prepareStatement(sql1);

            pStmt.setString(1, groups.getYourself());
            pStmt.setString(2, groups.getGroup());
            pStmt.setDate(3, (java.sql.Date) groups.getJoinTime());


            cnt = pStmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return -2;
        } finally {
            JdbcUtils.closeRes(conn, pStmt, null);

        }
        return cnt;
    }
    //解散群
    public int deleteGroup(String group) {
        Connection conn = null;
        PreparedStatement pStmt = null;
        int cnt=0;
        try {
            conn = JdbcUtils.getConnection();
            String sql1 = "delete groupsinfo where group=?";
            pStmt = conn.prepareStatement(sql1);

            pStmt.setString(1, group);



            cnt = pStmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return -2;
        } finally {
            JdbcUtils.closeRes(conn, pStmt, null);

        }
        return cnt;
    }

    //删除群成员
    public int deleteGroupUser(String user) {
        Connection conn = null;
        PreparedStatement pStmt = null;
        int cnt=0;
        try {
            conn = JdbcUtils.getConnection();
            String sql1 = "delete groupsinfo where yourself=?";
            pStmt = conn.prepareStatement(sql1);

            pStmt.setString(1, user);



            cnt = pStmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return -2;
        } finally {
            JdbcUtils.closeRes(conn, pStmt, null);

        }
        return cnt;
    }

}
