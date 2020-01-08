package com.qy.crm.modules.selection.controller;

import com.qy.crm.data.pojo.News;
import com.qy.crm.data.pojo.SelectInfo;
import com.qy.crm.data.pojo.common.Desc;
import com.qy.crm.data.pojo.common.IdParam;
import com.qy.crm.data.pojo.common.MapResult;
import com.qy.crm.data.pojo.common.PageResult;
import com.qy.crm.data.pojo.param.NewsPageParam;
import com.qy.crm.data.pojo.param.SelectionPageParam;
import com.qy.crm.modules.news.service.NewsService;
import com.qy.crm.modules.selection.service.SelectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * @Created by wangzhifeng
 * @Date 2020/1/7 14:13
 * @Description 精选文章管理
 */

@RestController
@RequestMapping(value = "/selection")
@Api("精选文章管理接口")
public class SelectionController {

    @Autowired
    private SelectionService selectionService;

    @PostMapping("/save")
    @ApiOperation(value = "添加/更新")
    public  ResponseEntity<Map<String,Object>> save(@RequestBody SelectInfo selectInfo) throws Exception{
        Desc desc = new Desc();

        if(Objects.isNull(selectInfo) || Objects.isNull(selectInfo.getRecordId())
                || Objects.isNull(selectInfo.getTable())){
            desc.setCode("1");
            desc.setDescription("入参错误！");
            return new ResponseEntity<Map<String, Object>>(MapResult.createResultMap("" , desc, ""), HttpStatus.OK);
        }

        selectInfo.setSelectDatetime(new Date());

        if (Objects.isNull(selectInfo.getId())) {
            //添加
            selectionService.insert(selectInfo);
            desc.setCode("2");
            desc.setDescription("添加成功");
            return new ResponseEntity<Map<String, Object>>(MapResult.createResultMap("" , desc, ""), HttpStatus.OK);
        }

        selectionService.update(selectInfo);

        desc.setCode("2");
        desc.setDescription("更新成功");
        return new ResponseEntity<Map<String, Object>>(MapResult.createResultMap("" , desc, ""), HttpStatus.OK);
    }

    @PostMapping("/pageData")
    @ApiOperation(value = "分页查询")
    public  ResponseEntity<Map<String,Object>> pageData(@RequestBody SelectionPageParam pageParam){
        Desc desc = new Desc();

        if (Objects.nonNull(pageParam.getDate()) && pageParam.getDate().length == 2) {
            pageParam.setStartTime(pageParam.getDate()[0]);
            pageParam.setEndTime(pageParam.getDate()[1]);
        }

        PageResult<SelectInfo> pageResult = selectionService.pageData(pageParam);

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

        SelectInfo selectInfo = selectionService.selectOne(Long.valueOf(param.getId()));

        desc.setCode("2");
        desc.setDescription("查询成功");
        return new ResponseEntity<Map<String, Object>>(MapResult.createResultMap("" , desc, selectInfo), HttpStatus.OK);
    }

}