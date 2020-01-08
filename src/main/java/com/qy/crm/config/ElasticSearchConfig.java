package com.qy.crm.config;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @Created by wangzhifeng
 * @Date 2020/1/8 11:49
 * @Description TODO
 */
@Configuration
public class ElasticSearchConfig {

    @PostConstruct
    void init() {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
    }
}
