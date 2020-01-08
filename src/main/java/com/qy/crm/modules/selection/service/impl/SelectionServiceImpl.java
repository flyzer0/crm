package com.qy.crm.modules.selection.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qy.crm.data.dao.InfoTagsMapper;
import com.qy.crm.data.dao.ReportMapper;
import com.qy.crm.data.dao.SelectInfoMapper;
import com.qy.crm.data.pojo.InfoTags;
import com.qy.crm.data.pojo.Report;
import com.qy.crm.data.pojo.SelectInfo;
import com.qy.crm.data.pojo.SelectTags;
import com.qy.crm.data.pojo.common.IdParam;
import com.qy.crm.data.pojo.common.PageResult;
import com.qy.crm.data.pojo.param.SelectionPageParam;
import com.qy.crm.exception.BusinessException;
import com.qy.crm.modules.selection.service.SelectionService;
import com.qy.crm.utils.FieldUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * @Created by wangzhifeng
 * @Date 2020/1/7 16:13
 * @Description TODO
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class SelectionServiceImpl implements SelectionService {

    @Autowired
    private SelectInfoMapper selectInfoMapper;

    @Autowired
    private InfoTagsMapper infoTagsMapper;

    @Autowired
    private ReportMapper reportMapper;



    public static String UNDERLINE = "_";

    @Override
    public int insert(SelectInfo selectInfo) throws Exception {

        String tableName = selectInfo.getTable();
        if(!tableName.equals("weixin") && !tableName.equals("news")){
            //研报需要根据规则建立es id
            Report report = reportMapper.selectByPrimaryKey(new IdParam(selectInfo.getRecordId(), selectInfo.getTable()));

            if(Objects.isNull(report)){
                throw new BusinessException("不存在该条记录！");
            }

            FieldUtil.getOrgnization(report);
            FieldUtil.getReportDate(report);
            FieldUtil.getTitle(report);

            String parseOrgnization = report.getParseOrgnization();
            String parseTitle = FieldUtil.cleanTitle(report.getParseTitle());
            String parseReportdate = FieldUtil.processDate(report.getParseReportdate());

            String esId = FieldUtil.getMD5(parseOrgnization + UNDERLINE
                + parseTitle + UNDERLINE + parseReportdate);
            log.info("es id:{}",esId);

            selectInfo.setRecordEsId(esId);

        }else{
            selectInfo.setRecordEsId(selectInfo.getRecordId());
        }
        //1.添加到mysql
        selectInfoMapper.insertSelective(selectInfo);
        batchInsertInfoTags(selectInfo);

        //2.同步到es TODO
        return 0;
    }

    @Override
    public int update(SelectInfo selectInfo) throws Exception {
        //1.更新到mysql
        selectInfoMapper.updateByPrimaryKeySelective(selectInfo);
        infoTagsMapper.deleteByInfoId(selectInfo.getId());
        batchInsertInfoTags(selectInfo);

        //2.同步到es TODO
        return 0;
    }

    @Override
    public int delete(SelectInfo selectInfo) throws Exception {
        //1.删除mysql中的记录，包括关联表
        selectInfoMapper.deleteByPrimaryKey(selectInfo.getId());
        infoTagsMapper.deleteByInfoId(selectInfo.getId());

        //2.同步到es TODO
        return 0;
    }

    @Override
    public PageResult<SelectInfo> pageData(SelectionPageParam pageParam) {
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
        Page<SelectInfo> pageData = selectInfoMapper.pageData(pageParam);
        return new PageResult<>(pageData.getResult(), pageData.getTotal());
    }

    @Override
    public SelectInfo selectOne(Long id) {
        return selectInfoMapper.selectById(id);
    }


    /**
     * 更新info_tags表
     * @param selectInfo
     */
    private void batchInsertInfoTags(SelectInfo selectInfo){
        if(Objects.isNull(selectInfo.getTags())){
            return;
        }
        for(SelectTags selectTags : selectInfo.getTags()){
            InfoTags infoTags = new InfoTags(selectInfo.getId(), selectTags.getId());
            infoTagsMapper.insert(infoTags);
        }
    }

}
