package mybeans;

import interfaces.Translate;
import myutils.ObjectTranslate;

import java.io.Serializable;

/**
 * 数据库实体
 * 用于存储用户注册、登录及验证所需信息
 */
public class Users implements Serializable{
    //用户id，自增
    private Long uid;
    //用户名
    private String username;
    //用户密码
    private String password;
    //用户认证码，用于密码的加密和认证
    private String identCode;

    public Users(){}

    public Users(Long uid, String username, String password, String identCode) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.identCode = identCode;

    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentCode() {
        return identCode;
    }

    public void setIdentCode(String identCode) {
        this.identCode = identCode;
    }



    @Override
    public String toString() {
        return "users{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", identCode='" + identCode + '\'' +
                '}';
    }
}
