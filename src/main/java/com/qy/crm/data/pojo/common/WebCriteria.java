package com.qy.crm.data.pojo.common;

import lombok.Getter;
import lombok.Setter;

/**
 * web端分页查询条件实体类
 */
public class WebCriteria {

    @Getter
    @Setter
    private int pageNum;

    @Getter
    @Setter
    private int pageSize  = 10;

    @Getter
    @Setter
    private String[] date;

    @Getter
    @Setter
    private String startTime;

    @Getter
    @Setter
    private String endTime;

    @Getter
    @Setter
    private int selection;

    @Getter
    @Setter
    private String tableName;

}
