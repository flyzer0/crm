package com.qy.crm.data.dao;

import com.github.pagehelper.Page;
import com.qy.crm.data.pojo.Weixin;
import com.qy.crm.data.pojo.common.IdParam;
import com.qy.crm.data.pojo.param.WeixinPageParam;
import org.springframework.stereotype.Repository;

@Repository
public interface WeixinMapper {
    Page<Weixin> pageData(WeixinPageParam param);

    Weixin selectOne(IdParam param);
}