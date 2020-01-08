package com.qy.crm.data.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.util.List;
import java.util.Objects;

/**
 * @Created by wangzhifeng
 * @Date 2020/1/8 10:06
 * @Description TODO
 */

public class NewsDocument {
    private Integer select_rating;
    private String select_title;
    private String select_stick;
    private String select_keypoint;
    private List<String> select_tags;

    public NewsDocument() {
    }

    public NewsDocument(Integer select_rating, String select_title, String select_stick, String select_keypoint, List<String> select_tags) {
        this.select_rating = select_rating;
        this.select_title = select_title;
        this.select_stick = select_stick;
        this.select_keypoint = select_keypoint;
        this.select_tags = select_tags;
    }

    public Integer getSelect_rating() {
        return select_rating;
    }

    public void setSelect_rating(Integer select_rating) {
        this.select_rating = select_rating;
    }

    public String getSelect_title() {
        return select_title;
    }

    public void setSelect_title(String select_title) {
        this.select_title = select_title;
    }

    public String getSelect_stick() {
        return select_stick;
    }

    public void setSelect_stick(String select_stick) {
        this.select_stick = select_stick;
    }

    public String getSelect_keypoint() {
        return select_keypoint;
    }

    public void setSelect_keypoint(String select_keypoint) {
        this.select_keypoint = select_keypoint;
    }

    public List<String> getSelect_tags() {
        return select_tags;
    }

    public void setSelect_tags(List<String> select_tags) {
        this.select_tags = select_tags;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        if(Objects.nonNull(select_rating)){
            builder.append("{\"select_rating\":" + select_rating + "}");
        }
        if(Objects.nonNull(select_title)){
            builder.append("{\"select_title\":\"" + select_title+ "\"}");
        }
        if(Objects.nonNull(select_stick)){
            builder.append("{\"select_stick\":\"" + select_stick+ "\"}");
        }
        if(Objects.nonNull(select_keypoint)){
            builder.append("{\"select_keypoint\":\"" + select_keypoint+ "\"}");
        }
        if(Objects.nonNull(select_tags)){
            builder.append("{\"select_tags\":\"" + select_tags+ "\"}");
        }
        builder.append("]");
        return builder.toString();
    }
}
