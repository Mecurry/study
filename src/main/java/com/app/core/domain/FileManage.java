package com.app.core.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 附件管理实体类
 */
@Entity
@Table(name="file_manage")
public class FileManage implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;//ID
    private int infoId;//附件对应的信息ID(PID)
    private String fileName;//附件名称
    private String filePath;//附件存储的本地路径
    private String dsc;//备注
    private Date createTime;//上传时间
    private int status;//状态

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
