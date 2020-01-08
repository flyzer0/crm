package com.qy.crm.data.pojo;

/**
 * @Created by wangzhifeng
 * @Date 2020/1/7 14:20
 * @Description TODO
 */
public class BaseVO {
    private String id;
    private int selection;
    private SelectInfo selectInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSelection() {
        return selection;
    }

    public void setSelection(int selection) {
        this.selection = selection;
    }

    public SelectInfo getSelectInfo() {
        return selectInfo;
    }

    public void setSelectInfo(SelectInfo selectInfo) {
        this.selectInfo = selectInfo;
    }
}
