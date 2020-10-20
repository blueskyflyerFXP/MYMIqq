package mybeans;
/**
 * 数据库实体
 * 用户详细信息
 * 用于注册和用户资料查询
 */

import interfaces.Translate;
import myutils.ObjectTranslate;

import java.io.Serializable;
import java.util.Date;

public class UserInfo {
    //用户名
    private String username;
    //用户昵称
    private String nickname;
    //用户用户头像
    private byte[] protraitPicture;
    //性别
    private String sex;
    //用户签名
    private String signature;
    //用户所在地
    private String locale;
    //用户生日
    private Date birthday;
    //用户联系电话
    private Integer telephone;
    //用户爱好
    private String hobby;
    //用户邮箱
    private String email;

    public UserInfo() {
    }

    public UserInfo(String username, String nickname, byte[] protraitPicture, String sex,
                    String signature, String locale, Date birthday, Integer telephone, String hobby, String email) {
        this.username = username;
        this.nickname = nickname;
        this.protraitPicture = protraitPicture;
        this.sex = sex;
        this.signature = signature;
        this.locale = locale;
        this.birthday = birthday;
        this.telephone = telephone;
        this.hobby = hobby;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public byte[] getProtraitPicture() {
        return protraitPicture;
    }

    public void setProtraitPicture(byte[] protraitPicture) {
        this.protraitPicture = protraitPicture;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
