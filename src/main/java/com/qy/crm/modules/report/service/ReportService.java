package com.qy.crm.modules.report.service;

import com.qy.crm.data.pojo.Report;
import com.qy.crm.data.pojo.common.IdParam;
import com.qy.crm.data.pojo.common.PageResult;
import com.qy.crm.data.pojo.param.ReportPageParam;

/**
 * @Created by wangzhifeng
 * @Date 2020/1/7 14:13
 * @Description TODO
 */
public interface ReportService {
    PageResult<Report> pageData(ReportPageParam pageParam);

    Report selectOne(IdParam param);
}
