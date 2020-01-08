package com.qy.crm.data.pojo;

import java.util.Date;

public class Report extends BaseVO {
    private String url;
    private String parseType;
    private String parseOrgnization;
    private String parseTitle;
    private Date parseReportdate;
    private String parseAuthors;
    private String parsePagecount;
    private String parseKeypoint;
    private String mandatoryTags;
    private String optionalTags;

    private Date reportdate;
    private String orgnization;
    private String title;

    public Date getReportdate() {
        return reportdate;
    }

    public void setReportdate(Date reportdate) {
        this.reportdate = reportdate;
    }

    public String getOrgnization() {
        return orgnization;
    }

    public void setOrgnization(String orgnization) {
        this.orgnization = orgnization;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParseType() {
        return parseType;
    }

    public void setParseType(String parseType) {
        this.parseType = parseType;
    }

    public String getParseOrgnization() {
        return parseOrgnization;
    }

    public void setParseOrgnization(String parseOrgnization) {
        this.parseOrgnization = parseOrgnization;
    }

    public String getParseTitle() {
        return parseTitle;
    }

    public void setParseTitle(String parseTitle) {
        this.parseTitle = parseTitle;
    }

    public Date getParseReportdate() {
        return parseReportdate;
    }

    public void setParseReportdate(Date parseReportdate) {
        this.parseReportdate = parseReportdate;
    }

    public String getParseAuthors() {
        return parseAuthors;
    }

    public void setParseAuthors(String parseAuthors) {
        this.parseAuthors = parseAuthors;
    }

    public String getParsePagecount() {
        return parsePagecount;
    }

    public void setParsePagecount(String parsePagecount) {
        this.parsePagecount = parsePagecount;
    }

    public String getParseKeypoint() {
        return parseKeypoint;
    }

    public void setParseKeypoint(String parseKeypoint) {
        this.parseKeypoint = parseKeypoint;
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