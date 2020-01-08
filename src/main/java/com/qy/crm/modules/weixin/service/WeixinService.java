package com.qy.crm.modules.weixin.service;

import com.qy.crm.data.pojo.Weixin;
import com.qy.crm.data.pojo.common.IdParam;
import com.qy.crm.data.pojo.common.PageResult;
import com.qy.crm.data.pojo.param.WeixinPageParam;

/**
 * @Created by wangzhifeng
 * @Date 2020/1/7 14:13
 * @Description TODO
 */
public interface WeixinService {
    PageResult<Weixin> pageData(WeixinPageParam pageParam);

    Weixin selectOne(IdParam param);
}
