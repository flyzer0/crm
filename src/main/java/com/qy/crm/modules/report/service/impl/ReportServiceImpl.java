package com.qy.crm.modules.report.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qy.crm.data.dao.ReportMapper;
import com.qy.crm.data.dao.SelectInfoMapper;
import com.qy.crm.data.pojo.Report;
import com.qy.crm.data.pojo.SelectInfo;
import com.qy.crm.data.pojo.common.IdParam;
import com.qy.crm.data.pojo.common.PageResult;
import com.qy.crm.data.pojo.param.ReportPageParam;
import com.qy.crm.modules.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;


/**
 * @Created by wangzhifeng
 * @Date 2020/1/7 14:13
 * @Description TODO
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportMapper reportMapper;

    @Autowired
    private SelectInfoMapper selectInfoMapper;

    @Override
    public PageResult<Report> pageData(ReportPageParam pageParam) {
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
        Page<Report> pageData = reportMapper.pageData(pageParam);
        return new PageResult<>(pageData.getResult(), pageData.getTotal());
    }

    @Override
    public Report selectOne(IdParam param) {
        Report report = reportMapper.selectOne(param);
        if(Objects.isNull(report)){
            return null;
        }
        SelectInfo selectInfo = selectInfoMapper.selectByRecordId(param);
        report.setSelectInfo(selectInfo);
        convertKeypoint(report);
        return report;
    }

    private void convertKeypoint(Report report){
        if(Objects.isNull(report.getParseKeypoint())){
            report.setParseKeypoint(null);
            return;
        }
        JSONObject keypointJson = JSONObject.parseObject(report.getParseKeypoint());
        if(keypointJson.containsKey("abstractRichText")){
            report.setParseKeypoint(keypointJson.getString("abstractRichText").trim());
        }
    }

}
