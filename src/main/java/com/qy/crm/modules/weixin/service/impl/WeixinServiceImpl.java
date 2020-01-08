package com.qy.crm.modules.weixin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qy.crm.data.dao.SelectInfoMapper;
import com.qy.crm.data.dao.WeixinMapper;
import com.qy.crm.data.pojo.SelectInfo;
import com.qy.crm.data.pojo.Weixin;
import com.qy.crm.data.pojo.common.IdParam;
import com.qy.crm.data.pojo.common.PageResult;
import com.qy.crm.data.pojo.param.WeixinPageParam;
import com.qy.crm.modules.weixin.service.WeixinService;
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
public class WeixinServiceImpl implements WeixinService {

    @Autowired
    private WeixinMapper weixinMapper;

    @Autowired
    private SelectInfoMapper selectInfoMapper;

    @Override
    public PageResult<Weixin> pageData(WeixinPageParam pageParam) {
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
        Page<Weixin> pageData = weixinMapper.pageData(pageParam);
        return new PageResult<>(pageData.getResult(), pageData.getTotal());
    }

    @Override
    public Weixin selectOne(IdParam param) {
        Weixin weixin = weixinMapper.selectOne(param);
        if(Objects.isNull(weixin)){
            return null;
        }
        SelectInfo selectInfo = selectInfoMapper.selectByRecordId(param);
        weixin.setSelectInfo(selectInfo);
        return weixin;
    }

}
