package com.qy.crm.modules.tags.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qy.crm.data.dao.InfoTagsMapper;
import com.qy.crm.data.dao.SelectTagsMapper;
import com.qy.crm.data.pojo.SelectTags;
import com.qy.crm.data.pojo.common.PageResult;
import com.qy.crm.data.pojo.param.TagsPageParam;
import com.qy.crm.exception.BusinessException;
import com.qy.crm.modules.tags.service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @Created by wangzhifeng
 * @Date 2020/1/6 14:13
 * @Description TODO
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TagsServiceImpl implements TagsService {

    @Autowired
    private SelectTagsMapper selectTagsMapper;

    @Autowired
    private InfoTagsMapper infoTagsMapper;

    @Override
    public int insert(SelectTags record) throws Exception{
        try {
            return selectTagsMapper.insert(record);
        }catch (Exception e){
            throw new BusinessException("添加标签失败!", e);
        }
    }

    @Override
    public int updateByPrimaryKey(SelectTags record) throws Exception{
        try {
            return selectTagsMapper.updateByPrimaryKey(record);
        }catch (Exception e){
            throw new BusinessException("更新标签失败!", e);
        }
    }

    @Override
    public int deleteByPrimaryKey(Long recordId) throws Exception{
        try{
            infoTagsMapper.deleteByTagId(recordId);
            return selectTagsMapper.deleteByPrimaryKey(recordId);
        }catch (Exception e){
            throw new BusinessException("删除标签失败!", e);
        }

    }

    @Override
    public PageResult<SelectTags> pageData(TagsPageParam pageParam) {
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
        Page<SelectTags> pageData = selectTagsMapper.pageData(pageParam.getTagName());
        return new PageResult<>(pageData.getResult(), pageData.getTotal());
    }

    @Override
    public List<SelectTags> selectAllName() {
        return selectTagsMapper.selectAllName();
    }
}
