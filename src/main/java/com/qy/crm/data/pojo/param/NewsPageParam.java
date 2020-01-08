package com.qy.crm.data.pojo.param;

import com.qy.crm.data.pojo.common.WebCriteria;
import lombok.Getter;
import lombok.Setter;

/**
 * @Created by wangzhifeng
 * @Date 2020/1/6 17:45
 * @Description TODO
 */
public class NewsPageParam extends WebCriteria {

    @Getter
    @Setter
    private String website;

    @Getter
    @Setter
    private String title;

}
