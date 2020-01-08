package com.qy.crm.data.pojo;

import java.util.Date;

/**
 * @Created by wangzhifeng
 * @Date 2020/1/7 14:19
 * @Description TODO
 */
public class Weixin extends BaseVO{
    private String title;
    private Date reportDate;
    private String gzhId;
    private String gzhName;
    private String mandatoryTags;
    private String optionalTags;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getGzhId() {
        return gzhId;
    }

    public void setGzhId(String gzhId) {
        this.gzhId = gzhId;
    }

    public String getGzhName() {
        return gzhName;
    }

    public void setGzhName(String gzhName) {
        this.gzhName = gzhName;
    }

    public String getMandatoryTags() {
        return mandatoryTags;
    }

    public void setMandatoryTags(String mandatoryTags) {
        this.mandatoryTags = mandatoryTags;
    }

    public String getOptionalTags() {
        return optionalTags;
    }

    public void setOptionalTags(String optionalTags) {
        this.optionalTags = optionalTags;
    }
}
