package com.qy.crm.modules.selection.service;

import com.qy.crm.data.pojo.SelectInfo;
import com.qy.crm.data.pojo.common.IdParam;
import com.qy.crm.data.pojo.common.PageResult;
import com.qy.crm.data.pojo.param.SelectionPageParam;

/**
 * @Created by wangzhifeng
 * @Date 2020/1/7 16:13
 * @Description TODO
 */
public interface SelectionService {
    int insert(SelectInfo selectInfo) throws Exception;

    int update(SelectInfo selectInfo) throws Exception;

    int delete(SelectInfo selectInfo) throws Exception;

    PageResult<SelectInfo> pageData(SelectionPageParam pageParam);

    SelectInfo selectOne(Long id);
}
