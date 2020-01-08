package com.qy.crm.data.dao;

import com.qy.crm.data.pojo.InfoTags;
import com.qy.crm.data.pojo.InfoTagsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoTagsMapper {
    long countByExample(InfoTagsExample example);

    int deleteByExample(InfoTagsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InfoTags record);

    int insertSelective(InfoTags record);

    List<InfoTags> selectByExample(InfoTagsExample example);

    InfoTags selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InfoTags record, @Param("example") InfoTagsExample example);

    int updateByExample(@Param("record") InfoTags record, @Param("example") InfoTagsExample example);

    int updateByPrimaryKeySelective(InfoTags record);

    int updateByPrimaryKey(InfoTags record);

    int deleteByTagId(Long tagId);

    int deleteByInfoId(Long infoId);
}