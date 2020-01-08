package com.qy.crm.modules.news.service;

import com.qy.crm.data.pojo.News;
import com.qy.crm.data.pojo.Weixin;
import com.qy.crm.data.pojo.common.IdParam;
import com.qy.crm.data.pojo.common.PageResult;
import com.qy.crm.data.pojo.param.NewsPageParam;
import com.qy.crm.data.pojo.param.WeixinPageParam;

/**
 * @Created by wangzhifeng
 * @Date 2020/1/7 14:13
 * @Description TODO
 */
public interface NewsService {
    PageResult<News> pageData(NewsPageParam pageParam);

    News selectOne(IdParam param);
}
