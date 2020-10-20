package dao;

import mybeans.Groups;
import myutils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GroupsDao {
    //查询群资料
    public ArrayList<Groups> queryGroup(String groupname){
        Connection conn = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        ArrayList<Groups> groupsList=null;
        try {
            String sql = "select * from groups where groupname=?";
            conn = JdbcUtils.getConnection();
            pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, groupname);

            rs = pStmt.executeQuery();
            groupsList=new ArrayList<>();
            while (rs.next()){
                Groups group=new Groups();
                group.setGid(rs.getLong("gid"));
                group.setGroupname(rs.getString("groupname"));
                group.setGroupOwer(rs.getString("groupower"));
                group.setCreateTime((java.util.Date)rs.getDate("createtime"));
                groupsList.add(group);
            }
            return groupsList;
        } catch (Exception e) {
            e.printStackTrace();
            //服务器异常
            groupsList=null;
        } finally {
            JdbcUtils.closeRes(conn, pStmt, rs);
        }
        return groupsList;
    }
    //创建群聊
    public int addGroup(Groups gro) {
        Connection conn = null;
        PreparedStatement pStmt = null;
        int cnt=0;
        try {
            conn = JdbcUtils.getConnection();
            String sql1 = "insert into users values(null,?,?,?)";
            pStmt = conn.prepareStatement(sql1);

            pStmt.setString(1, gro.getGroupname());
            pStmt.setString(2, gro.getGroupOwer());

            pStmt.setDate(3, (java.sql.Date) gro.getCreateTime());


            cnt = pStmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return -2;
        } finally {
            JdbcUtils.closeRes(conn, pStmt, null);

        }
        return cnt;
    }
    //转让群主和修改群名称
    public  int updateGroup(Groups groups){
        Connection conn = null;
        PreparedStatement pStmt = null;
        int cnt=0;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "update groups set  groupname=? and groupname=? where gid=?";
            pStmt = conn.prepareStatement(sql);


            pStmt.setString(1, groups.getGroupname());
            pStmt.setString(2, groups.getGroupOwer());
            pStmt.setLong(3, groups.getGid());

            cnt = pStmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return -2;
        } finally {
            JdbcUtils.closeRes(conn, pStmt, null);

        }
        return cnt;
    }
    //解散群聊
    public int deleteUser(Groups groups){
        Connection conn = null;
        PreparedStatement pStmt = null;
        int cnt=0;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "delete groups where groupname=?";
            pStmt = conn.prepareStatement(sql);

            pStmt.setString(1, groups.getGroupname());

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
