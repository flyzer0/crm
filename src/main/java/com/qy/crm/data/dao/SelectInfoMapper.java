package com.qy.crm.data.dao;

import com.github.pagehelper.Page;
import com.qy.crm.data.pojo.SelectInfo;
import com.qy.crm.data.pojo.SelectInfoExample;
import java.util.List;

import com.qy.crm.data.pojo.common.IdParam;
import com.qy.crm.data.pojo.param.SelectionPageParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SelectInfoMapper {
    long countByExample(SelectInfoExample example);

    int deleteByExample(SelectInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SelectInfo record);

    int insertSelective(SelectInfo record);

    List<SelectInfo> selectByExampleWithBLOBs(SelectInfoExample example);

    List<SelectInfo> selectByExample(SelectInfoExample example);

    SelectInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SelectInfo record, @Param("example") SelectInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") SelectInfo record, @Param("example") SelectInfoExample example);

    int updateByExample(@Param("record") SelectInfo record, @Param("example") SelectInfoExample example);

    int updateByPrimaryKeySelective(SelectInfo record);

    int updateByPrimaryKeyWithBLOBs(SelectInfo record);

    int updateByPrimaryKey(SelectInfo record);

    SelectInfo selectByRecordId(IdParam param);

    Page<SelectInfo> pageData(SelectionPageParam pageParam);

    SelectInfo selectById(@Param("id") Long id);

}