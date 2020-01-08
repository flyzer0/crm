package com.qy.crm.modules.tags.controller;

import com.qy.crm.data.pojo.SelectTags;
import com.qy.crm.data.pojo.common.*;
import com.qy.crm.data.pojo.param.TagsPageParam;
import com.qy.crm.modules.tags.service.TagsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Created by wangzhifeng
 * @Date 2020/1/6 14:13
 * @Description 标签管理
 */

@RestController
@RequestMapping(value = "/tags")
@Api("标签管理接口")
public class TagsController {

    @Autowired
    private TagsService tagsService;

    @PostMapping("/save")
    @ApiOperation(value = "添加或更新标签", notes = "如果传过来的id为null，则为添加；不为空，则更新")
    public ResponseEntity<Map<String, Object>> save(@RequestBody SelectTags tags)  throws Exception{
        Desc desc = new Desc();
        if(Objects.isNull(tags.getId())){
            tagsService.insert(tags);
            desc.setDescription("新增成功");
            desc.setCode("1");
            return new ResponseEntity<Map<String, Object>>(MapResult.createResultMap("", desc, ""), HttpStatus.OK);
        }
        tagsService.updateByPrimaryKey(tags);
        desc.setDescription("修改成功");
        desc.setCode("1");
        return new ResponseEntity<Map<String, Object>>(MapResult.createResultMap("", desc, ""), HttpStatus.OK);
    }

    @PostMapping("/pageData")
    @ApiOperation(value = "分页查询")
    public  ResponseEntity<Map<String,Object>> pageData(@RequestBody TagsPageParam pageParam){
        Desc desc = new Desc();
        PageResult<SelectTags> pageResult = tagsService.pageData(pageParam);

        desc.setCode("2");
        desc.setDescription("查询成功");
        return new ResponseEntity<Map<String, Object>>(MapResult.createResultMap("" , desc, pageResult), HttpStatus.OK);
    }

    @PostMapping("/deleteOne")
    @ApiOperation(value = "删除标签")
    public ResponseEntity<Map<String,Object>> deleteOne(@RequestBody SelectTags tags) throws Exception {
        Desc desc = new Desc();
        tagsService.deleteByPrimaryKey(tags.getId());

        desc.setCode("1");
        desc.setDescription("删除成功");
        return new ResponseEntity<Map<String, Object>>(MapResult.createResultMap("" , desc, ""), HttpStatus.OK);
    }

    @GetMapping("/getAllName")
    @ApiOperation(value = "分页查询")
    public  ResponseEntity<Map<String,Object>> getAllName() {
        Desc desc = new Desc();
        List<SelectTags> result = tagsService.selectAllName();

        desc.setCode("2");
        desc.setDescription("查询成功");
        return new ResponseEntity<Map<String, Object>>(MapResult.createResultMap("" , desc, result), HttpStatus.OK);
    }

}