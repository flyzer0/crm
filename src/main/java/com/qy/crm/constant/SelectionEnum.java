package com.qy.crm.constant;

/**
 * @Created by wangzhifeng
 * @Date 2020/1/6 18:29
 * @Description TODO
 */
public enum SelectionEnum {
    UN_SELECTION(0, "非精选"),
    SELECTION(1, "精选"),
    ALL(2, "全部");

    private int code;
    private String desc;

    SelectionEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }
}
