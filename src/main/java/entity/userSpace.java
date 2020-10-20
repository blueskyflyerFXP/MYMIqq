package entity;
/**
 * 用户空间
 * 为聊天开辟的临时空间
 */

import java.util.ArrayList;

public class userSpace {
    //用户名
    public String username;
    //聊天列表
    public ArrayList<String> chatList;
    //好友列表
    public ArrayList<String> friendList;
    //聊天消息列表
    public ArrayList<byte[]> msgList;

    public userSpace() {
    }

    public userSpace(String username, ArrayList<String> chatList, ArrayList<String> friendList, ArrayList<byte[]> msgList) {
        this.username = username;
        this.chatList = chatList;
        this.friendList = friendList;
        this.msgList = msgList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<String> getChatList() {
        return chatList;
    }

    public void setChatList(ArrayList<String> chatList) {
        this.chatList = chatList;
    }

    public ArrayList<String> getFriendList() {
        return friendList;
    }

    public void setFriendList(ArrayList<String> friendList) {
        this.friendList = friendList;
    }

    public ArrayList<byte[]> getMsgList() {
        return msgList;
    }

    public void setMsgList(ArrayList<byte[]> msgList) {
        this.msgList = msgList;
    }
}
