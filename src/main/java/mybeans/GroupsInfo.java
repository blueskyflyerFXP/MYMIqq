package mybeans;
/**
 * 数据库实体
 * 用于记录加入的群组信息
 */

import interfaces.Translate;
import myutils.ObjectTranslate;

import java.io.Serializable;
import java.util.Date;

public class GroupsInfo {
    //群组连线号
    private Long gsid;
    //自己
    private String yourself;
    //群组名
    private String group;
    //加入群聊的时间
    private Date joinTime;

    public GroupsInfo() {
    }

    public GroupsInfo(Long gsid, String yourself, String group, Date joinTime) {
        this.gsid = gsid;
        this.yourself = yourself;
        this.group = group;
        this.joinTime = joinTime;
    }

    public Long getGsid() {
        return gsid;
    }

    public void setGsid(Long gsid) {
        this.gsid = gsid;
    }

    public String getYourself() {
        return yourself;
    }

    public void setYourself(String yourself) {
        this.yourself = yourself;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }


}
