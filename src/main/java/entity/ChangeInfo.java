package entity;

import java.io.Serializable;

/**
 * 网络传输类
 * 用于标记发送方和接收方的IP地址和端口等信息
 */
public class ChangeInfo implements Serializable {
    //IP地址
    private String changeAddress;
    //端口
    private int changePort;
    //用户
    private String username;

    public ChangeInfo() {
    }

    public ChangeInfo(String changeAddress, int changePort, String username) {
        this.changeAddress = changeAddress;
        this.changePort = changePort;
        this.username = username;
    }

    public String getChangeAddress() {
        return changeAddress;
    }

    public void setChangeAddress(String changeAddress) {
        this.changeAddress = changeAddress;
    }

    public int getChangePort() {
        return changePort;
    }

    public void setChangePort(int changePort) {
        this.changePort = changePort;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "ChangeInfo{" +
                "changeAddress='" + changeAddress + '\'' +
                ", changePort=" + changePort +
                ", username='" + username + '\'' +
                '}';
    }
}
