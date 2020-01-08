package com.qy.crm.data.pojo;

public class InfoTags {
    private Long id;

    private Long infoId;

    private Long tagId;

    public InfoTags(Long infoId, Long tagId) {
        this.infoId = infoId;
        this.tagId = tagId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInfoId() {
        return infoId;
    }

    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }
}