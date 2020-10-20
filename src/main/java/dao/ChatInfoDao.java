package dao;

import mybeans.ChatInfo;
import myutils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class ChatInfoDao {

    //添加聊天记录
    public int addChat(ChatInfo chat) {
        Connection conn = null;
        PreparedStatement pStmt = null;
        int cnt = 0;
        try {
            conn = JdbcUtils.getConnection();
            String sql1 = "insert into users values(null,?,?,?,?,?,?)";
            pStmt = conn.prepareStatement(sql1);

            pStmt.setString(1, chat.getYourself());
            pStmt.setString(2, chat.getChatUser());
            pStmt.setBoolean(3, chat.getChatType());
            pStmt.setString(4, chat.getMsgType());
            pStmt.setBytes(5, chat.getMessage());
            pStmt.setDate(6, (java.sql.Date) chat.getChatTime());
            cnt = pStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            cnt = -2;
        } finally {
            JdbcUtils.closeRes(conn, pStmt, null);
        }
        return cnt;
    }

    //查询聊天记录
    public ArrayList<ChatInfo> queryChat(ChatInfo chat){
        ArrayList<ChatInfo> chatList=new ArrayList<>();
        Connection conn = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from chatinfo where yourself=? and chatuser=?";
            conn = JdbcUtils.getConnection();
            pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, chat.getYourself());
            pStmt.setString(2,chat.getChatUser());
            rs = pStmt.executeQuery();

            while (rs.next()) {
            ChatInfo chatInfo=new ChatInfo();
            chatInfo.setChatSpaceId(rs.getLong("chatspaceid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeRes(conn, pStmt, rs);
        }
        return chatList;
    }
    //删除聊天记录(根据用户、聊天对象和截止日期）
    public int deleteChat(String self, String user, Date expTime){
        Connection conn = null;
        PreparedStatement pStmt = null;
        int cnt=0;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "delete chatinfo where yourself=? and chatuser=? and to_days(chattime)<to_days(?)";
            pStmt = conn.prepareStatement(sql);

            pStmt.setString(1,self);
            pStmt.setString(2,user);
            pStmt.setDate(3,(java.sql.Date)expTime);

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
