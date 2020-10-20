package mybeans;
/**
 * 数据库实体
 * 用于记录聊天发送的消息
 */

import interfaces.Translate;
import myutils.ObjectTranslate;

import java.io.Serializable;
import java.util.Date;
/**
 * 数据库实体
 * 用于记录聊天发送的消息
 */
public class ChatInfo {
    //聊天空间号
    private Long chatSpaceId;
    //你自己
    private String yourself;
    //聊天类型：私聊、群聊
    private Boolean chatType;
    //聊天对象
    private String chatUser;
    //聊天发送消息的类型：普通消息、文件、图片
    private String msgType;
    //聊天发送的内容
    private byte[] message;
    //发送消息的时间
    private Date chatTime;

    public ChatInfo() {
    }

    public ChatInfo(Long chatSpaceId, String yourself, Boolean chatType, String chatUser, String msgType, byte[] message, Date chatTime) {
        this.chatSpaceId = chatSpaceId;
        this.yourself = yourself;
        this.chatType = chatType;
        this.chatUser = chatUser;
        this.msgType = msgType;
        this.message = message;
        this.chatTime = chatTime;
    }

    public Long getChatSpaceId() {
        return chatSpaceId;
    }

    public void setChatSpaceId(Long chatSpaceId) {
        this.chatSpaceId = chatSpaceId;
    }

    public String getYourself() {
        return yourself;
    }

    public void setYourself(String yourself) {
        this.yourself = yourself;
    }

    public Boolean getChatType() {
        return chatType;
    }

    public void setChatType(Boolean chatType) {
        this.chatType = chatType;
    }

    public String getChatUser() {
        return chatUser;
    }

    public void setChatUser(String chatUser) {
        this.chatUser = chatUser;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public byte[] getMessage() {
        return message;
    }

    public void setMessage(byte[] message) {
        this.message = message;
    }

    public Date getChatTime() {
        return chatTime;
    }

    public void setChatTime(Date chatTime) {
        this.chatTime = chatTime;
    }

}
