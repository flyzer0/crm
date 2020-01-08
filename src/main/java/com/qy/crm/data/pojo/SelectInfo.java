package com.qy.crm.data.pojo;

import java.util.Date;
import java.util.List;

public class SelectInfo {
    private Long id;

    private String table;

    private String recordId;

    private String recordEsId;

    private Integer selectRating;

    private Date selectDatetime;

    private String selectTitle;

    private String selectStick;

    private String selectKeypoint;

    private List<SelectTags> tags;

    public List<SelectTags> getTags() {
        return tags;
    }

    public void setTags(List<SelectTags> tags) {
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table == null ? null : table.trim();
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId == null ? null : recordId.trim();
    }

    public String getRecordEsId() {
        return recordEsId;
    }

    public void setRecordEsId(String recordEsId) {
        this.recordEsId = recordEsId == null ? null : recordEsId.trim();
    }

    public Integer getSelectRating() {
        return selectRating;
    }

    public void setSelectRating(Integer selectRating) {
        this.selectRating = selectRating;
    }

    public Date getSelectDatetime() {
        return selectDatetime;
    }

    public void setSelectDatetime(Date selectDatetime) {
        this.selectDatetime = selectDatetime;
    }

    public String getSelectTitle() {
        return selectTitle;
    }

    public void setSelectTitle(String selectTitle) {
        this.selectTitle = selectTitle == null ? null : selectTitle.trim();
    }

    public String getSelectStick() {
        return selectStick;
    }

    public void setSelectStick(String selectStick) {
        this.selectStick = selectStick == null ? null : selectStick.trim();
    }

    public String getSelectKeypoint() {
        return selectKeypoint;
    }

    public void setSelectKeypoint(String selectKeypoint) {
        this.selectKeypoint = selectKeypoint == null ? null : selectKeypoint.trim();
    }
}