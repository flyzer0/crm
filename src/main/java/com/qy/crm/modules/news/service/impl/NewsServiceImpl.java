package com.qy.crm.modules.news.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qy.crm.data.dao.NewsMapper;
import com.qy.crm.data.dao.SelectInfoMapper;
import com.qy.crm.data.dao.WeixinMapper;
import com.qy.crm.data.pojo.News;
import com.qy.crm.data.pojo.SelectInfo;
import com.qy.crm.data.pojo.Weixin;
import com.qy.crm.data.pojo.common.IdParam;
import com.qy.crm.data.pojo.common.PageResult;
import com.qy.crm.data.pojo.param.NewsPageParam;
import com.qy.crm.data.pojo.param.WeixinPageParam;
import com.qy.crm.modules.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;


/**
 * @Created by wangzhifeng
 * @Date 2020/1/7 14:13
 * @Description TODO
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private SelectInfoMapper selectInfoMapper;

    @Override
    public PageResult<News> pageData(NewsPageParam pageParam) {
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
        Page<News> pageData = newsMapper.pageData(pageParam);
        return new PageResult<>(pageData.getResult(), pageData.getTotal());
    }

    @Override
    public News selectOne(IdParam param) {
        News news = newsMapper.selectOne(param);
        if(Objects.isNull(news)){
            return null;
        }
        SelectInfo selectInfo = selectInfoMapper.selectByRecordId(param);
        news.setSelectInfo(selectInfo);
        return news;
    }

}
