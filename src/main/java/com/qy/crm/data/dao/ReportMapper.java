package com.qy.crm.data.dao;

import com.github.pagehelper.Page;

import com.qy.crm.data.pojo.Report;
import com.qy.crm.data.pojo.common.IdParam;
import com.qy.crm.data.pojo.param.ReportPageParam;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportMapper {
    Page<Report> pageData(ReportPageParam param);

    Report selectOne(IdParam param);

    Report selectByPrimaryKey(IdParam param);
}