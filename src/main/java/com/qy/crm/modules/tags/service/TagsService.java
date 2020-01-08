package com.qy.crm.modules.tags.service;

import com.qy.crm.data.pojo.SelectTags;
import com.qy.crm.data.pojo.common.PageResult;
import com.qy.crm.data.pojo.param.TagsPageParam;

import java.util.List;

/**
 * @Created by wangzhifeng
 * @Date 2020/1/6 14:13
 * @Description TODO
 */
public interface TagsService {
    int insert(SelectTags record) throws Exception;
    int updateByPrimaryKey(SelectTags record) throws Exception;
    int deleteByPrimaryKey(Long recordId) throws Exception;
    PageResult<SelectTags> pageData(TagsPageParam pageParam);
    List<SelectTags> selectAllName();
}
