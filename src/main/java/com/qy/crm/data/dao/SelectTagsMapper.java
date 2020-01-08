package com.qy.crm.data.dao;

import com.github.pagehelper.Page;
import com.qy.crm.data.pojo.SelectTags;
import com.qy.crm.data.pojo.SelectTagsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SelectTagsMapper {
    long countByExample(SelectTagsExample example);

    int deleteByExample(SelectTagsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SelectTags record);

    int insertSelective(SelectTags record);

    List<SelectTags> selectByExample(SelectTagsExample example);

    SelectTags selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SelectTags record, @Param("example") SelectTagsExample example);

    int updateByExample(@Param("record") SelectTags record, @Param("example") SelectTagsExample example);

    int updateByPrimaryKeySelective(SelectTags record);

    int updateByPrimaryKey(SelectTags record);

    Page<SelectTags> pageData(@Param("name") String name);

    List<SelectTags> selectAllName();

}