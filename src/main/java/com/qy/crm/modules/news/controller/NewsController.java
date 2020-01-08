package com.qy.crm.modules.news.controller;

import com.qy.crm.data.pojo.News;
import com.qy.crm.data.pojo.Weixin;
import com.qy.crm.data.pojo.common.Desc;
import com.qy.crm.data.pojo.common.IdParam;
import com.qy.crm.data.pojo.common.MapResult;
import com.qy.crm.data.pojo.common.PageResult;
import com.qy.crm.data.pojo.param.NewsPageParam;
import com.qy.crm.modules.news.service.NewsService;
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
 * @Description 资讯管理
 */

@RestController
@RequestMapping(value = "/news")
@Api("资讯管理接口")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @PostMapping("/pageData")
    @ApiOperation(value = "分页查询")
    public  ResponseEntity<Map<String,Object>> pageData(@RequestBody NewsPageParam pageParam){
        Desc desc = new Desc();

        if (Objects.nonNull(pageParam.getDate()) && pageParam.getDate().length == 2) {
            pageParam.setStartTime(pageParam.getDate()[0]);
            pageParam.setEndTime(pageParam.getDate()[1]);
        }

        pageParam.setTableName("news");

        PageResult<News> pageResult = newsService.pageData(pageParam);

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
        News news = newsService.selectOne(param);

        desc.setCode("2");
        desc.setDescription("查询成功");
        return new ResponseEntity<Map<String, Object>>(MapResult.createResultMap("" , desc, news), HttpStatus.OK);
    }

}