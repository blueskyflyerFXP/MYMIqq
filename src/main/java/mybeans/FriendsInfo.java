package mybeans;


import interfaces.Translate;
import myutils.ObjectTranslate;

import java.io.Serializable;
import java.util.Date;
/**
 * 数据库实体
 * 好友信息
 */
public class FriendsInfo {
    //好友连线号
    private Long fid;
    //用户自己
    private String myself;
    //好友
    private String friend;
    //备注
    private String remark;
    //成为好友的时间
    private Date shipTime;

    public FriendsInfo() {
    }

    public FriendsInfo(Long fid, String myself, String friend, String remark, Date shipTime) {
        this.fid = fid;
        this.myself = myself;
        this.friend = friend;
        this.remark = remark;
        this.shipTime = shipTime;
    }

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public String getMyself() {
        return myself;
    }

    public void setMyself(String myself) {
        this.myself = myself;
    }

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getShipTime() {
        return shipTime;
    }

    public void setShipTime(Date shipTime) {
        this.shipTime = shipTime;
    }

}
