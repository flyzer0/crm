package com.qy.crm.data.pojo.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @Created by wangzhifeng
 * @Date 2020/1/7 11:26
 * @Description TODO
 */
@AllArgsConstructor
public class IdParam {
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String tableName;
}
