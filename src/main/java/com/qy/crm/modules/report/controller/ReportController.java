package com.qy.crm.modules.report.controller;

import com.qy.crm.data.pojo.Report;
import com.qy.crm.data.pojo.common.*;
import com.qy.crm.data.pojo.param.ReportPageParam;
import com.qy.crm.modules.report.service.ReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

/**
 * @Created by wangzhifeng
 * @Date 2020/1/7 14:13
 * @Description 研报管理
 */

@RestController
@RequestMapping(value = "/report")
@Api("研报管理接口")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping("/pageData")
    @ApiOperation(value = "分页查询")
    public  ResponseEntity<Map<String,Object>> pageData(@RequestBody ReportPageParam pageParam){
        Desc desc = new Desc();

        if(Objects.isNull(pageParam) || Objects.isNull(pageParam.getTableName())){
            desc.setCode("1");
            desc.setDescription("入参错误！");
            return new ResponseEntity<Map<String, Object>>(MapResult.createResultMap("" , desc, ""), HttpStatus.OK);
        }

        if (Objects.nonNull(pageParam.getDate()) && pageParam.getDate().length == 2) {
            pageParam.setStartTime(pageParam.getDate()[0]);
            pageParam.setEndTime(pageParam.getDate()[1]);
        }

        PageResult<Report> pageResult = reportService.pageData(pageParam);

        desc.setCode("2");
        desc.setDescription("查询成功");
        return new ResponseEntity<Map<String, Object>>(MapResult.createResultMap("" , desc, pageResult), HttpStatus.OK);
    }

    @PostMapping("/findOne")
    @ApiOperation(value = "查询某条数据")
    public  ResponseEntity<Map<String,Object>> findOne(@RequestBody IdParam param){
        Desc desc = new Desc();
        if(Objects.isNull(param) || Objects.isNull(param.getId()) || Objects.isNull(param.getTableName())){
            desc.setCode("1");
            desc.setDescription("入参错误！");
            return new ResponseEntity<Map<String, Object>>(MapResult.createResultMap("" , desc, ""), HttpStatus.OK);
        }

        Report report = reportService.selectOne(param);

        desc.setCode("2");
        desc.setDescription("查询成功");
        return new ResponseEntity<Map<String, Object>>(MapResult.createResultMap("" , desc, report), HttpStatus.OK);
    }

}