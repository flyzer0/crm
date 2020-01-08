package com.qy.crm.modules.selection.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qy.crm.data.pojo.NewsDocument;
import com.qy.crm.utils.BeanUtil;
import org.elasticsearch.action.update.UpdateRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.UpdateQuery;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Created by wangzhifeng
 * @Date 2020/1/8 10:52
 * @Description TODO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SelectionServiceImplTest {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void insert() {
        NewsDocument document = new NewsDocument();
        document.setSelect_keypoint("dsadas");
        List<String> list = new ArrayList<>();
        document.setSelect_tags(list);
        UpdateQuery updateQuery = new UpdateQuery();
        updateQuery.setIndexName("index_1");
        updateQuery.setType("doc");
        updateQuery.setId("11");
        UpdateRequest request = new UpdateRequest();
        request.doc(BeanUtil.bean2Map(document));
        updateQuery.setUpdateRequest(request);
        elasticsearchTemplate.update(updateQuery);
    }
}