package com.qy.crm.filter;

import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by THTF on 2017-12-14.
 */
@Configuration
public class FilterConfiguration {
    @Bean
    public FilterRegistrationBean druidStatFilterBean() {
       // 配置完成，启动应用，打开http://localhost:8000/druid/ 用ServletConfiguration.java配置的账号密码登录，
        // 即可进入druid监控后台。
        FilterRegistrationBean druidStatFilterBean=new FilterRegistrationBean(new WebStatFilter());
        List<String> urlPattern=new ArrayList<>();
        urlPattern.add("/*");
        druidStatFilterBean.setUrlPatterns(urlPattern);
        Map<String,String> initParams=new HashMap<>();
        initParams.put("exclusions","*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
        druidStatFilterBean.setInitParameters(initParams);
        return druidStatFilterBean;
    }
}