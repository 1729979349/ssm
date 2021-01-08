package com.zking.ssm.model;

import lombok.Builder;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Builder
public class BookFile implements Serializable {
    private String fileId;

    private String realName;

    private String contentType;

    public BookFile(String fileId, String realName, String contentType) {
        this.fileId = fileId;
        this.realName = realName;
        this.contentType = contentType;
    }

    public BookFile() {
        super();
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}