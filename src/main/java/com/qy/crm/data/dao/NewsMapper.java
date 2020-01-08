package com.qy.crm.data.dao;

import com.github.pagehelper.Page;
import com.qy.crm.data.pojo.News;
import com.qy.crm.data.pojo.common.IdParam;
import com.qy.crm.data.pojo.param.NewsPageParam;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsMapper {
    Page<News> pageData(NewsPageParam param);

    News selectOne(IdParam param);
}