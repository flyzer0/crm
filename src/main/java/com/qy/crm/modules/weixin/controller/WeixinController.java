package com.qy.crm.modules.weixin.controller;

import com.qy.crm.data.pojo.Weixin;
import com.qy.crm.data.pojo.common.*;
import com.qy.crm.data.pojo.param.WeixinPageParam;
import com.qy.crm.modules.weixin.service.WeixinService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

/**
 * @Created by wangzhifeng
 * @Date 2020/1/7 14:13
 * @Description 微信管理
 */

@RestController
@RequestMapping(value = "/weixin")
@Api("微信管理接口")
public class WeixinController {

    @Autowired
    private WeixinService weixinService;

    @PostMapping("/pageData")
    @ApiOperation(value = "分页查询")
    public  ResponseEntity<Map<String,Object>> pageData(@RequestBody WeixinPageParam pageParam){
        Desc desc = new Desc();

        if (Objects.nonNull(pageParam.getDate()) && pageParam.getDate().length == 2) {
            pageParam.setStartTime(pageParam.getDate()[0]);
            pageParam.setEndTime(pageParam.getDate()[1]);
        }

        pageParam.setTableName("weixin");

        PageResult<Weixin> pageResult = weixinService.pageData(pageParam);

        desc.setCode("2");
        desc.setDescription("查询成功");
        return new ResponseEntity<Map<String, Object>>(MapResult.createResultMap("" , desc, pageResult), HttpStatus.OK);
    }

    @PostMapping("/findOne")
    @ApiOperation(value = "查询某条数据")
    public  ResponseEntity<Map<String,Object>> findOne(@RequestBody IdParam param){
        Desc desc = new Desc();
        if(Objects.isNull(param) || Objects.isNull(param.getId())){
            desc.setCode("1");
            desc.setDescription("入参错误！");
            return new ResponseEntity<Map<String, Object>>(MapResult.createResultMap("" , desc, ""), HttpStatus.OK);
        }

        param.setTableName("weixin");
        Weixin weixin = weixinService.selectOne(param);

        desc.setCode("2");
        desc.setDescription("查询成功");
        return new ResponseEntity<Map<String, Object>>(MapResult.createResultMap("" , desc, weixin), HttpStatus.OK);
    }

}