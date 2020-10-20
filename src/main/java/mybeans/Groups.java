package mybeans;


import interfaces.Translate;
import myutils.ObjectTranslate;

import java.io.Serializable;
import java.util.Date;
/**
 * 数据库实体
 * 用于记录群组信息
 */
public class Groups {
    //群组号
    private Long gid;
    //群名称
    private String groupname;
    //群主
    private String groupOwer;
    //建群时间
    private Date createTime;

    public Groups() {
    }

    public Groups(Long gid, String groupname, String groupOwer, Date createTime) {
        this.gid = gid;
        this.groupname = groupname;
        this.groupOwer = groupOwer;
        this.createTime = createTime;
    }

    public Groups(Long gid, String groupname, Date createTime) {
        this.gid = gid;
        this.groupname = groupname;
        this.createTime = createTime;
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getGroupOwer() {
        return groupOwer;
    }

    public void setGroupOwer(String groupOwer) {
        this.groupOwer = groupOwer;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
