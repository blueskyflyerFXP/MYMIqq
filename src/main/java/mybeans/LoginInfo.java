package mybeans;
/**
 * 数据库实体
 * 用于登记用户登录的各种信息
 */

import interfaces.Translate;
import myutils.ObjectTranslate;

import java.io.Serializable;
import java.util.Date;

public class LoginInfo {
    //用户
    private String username;
    //用户登录时的IP地址
    private String userIp;
    //用户在线状态
    private Boolean onlineState;
    //用户最近登录时间
    private Date loginTime;

    public LoginInfo() {
    }

    public LoginInfo(String username, String userIp, Boolean onlineState, Date loginTime) {
        this.username = username;
        this.userIp = userIp;
        this.onlineState = onlineState;
        this.loginTime = loginTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public Boolean getOnlineState() {
        return onlineState;
    }

    public void setOnlineState(Boolean onlineState) {
        this.onlineState = onlineState;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }


}
