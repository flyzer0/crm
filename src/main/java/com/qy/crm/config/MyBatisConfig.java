package com.qy.crm.config;

/**
 * Created by THTF on 2017-12-14.
 */
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Configuration
@MapperScan(basePackages = "com.qy.crm.data.dao")
public class MyBatisConfig {
    @Value("${spring.datasource.url}")
    String dbUrl;
    @Value("${spring.datasource.username}")
    String userName;
    @Value("${spring.datasource.password}")
    String password;
    @Value("${spring.datasource.driverClassName}")
    String driverClassName;
    @Value("${spring.datasource.tomcat.validation-query}")
    String validationQuery;
    @Value("${spring.datasource.tomcat.validation-query-timeout}")
    String validationQueryTimeout;
    @Value("${spring.datasource.tomcat.test-on-borrow}")
    String testOnBorrow;

    private static final String MYBATIS_CONFIG = "mybatis_config.xml";
    private static final String MAPPER_PATH = "/com/qy/crm/data/mapper/*.xml";

    @Bean
    public SqlSessionFactoryBean createSqlSessionFactoryBean(@Qualifier("dataSource")DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //设置mybatis config 扫描路径
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(MYBATIS_CONFIG));
        //添加mapper 扫描路径
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + MAPPER_PATH;
        sqlSessionFactoryBean.setMapperLocations(pathMatchingResourcePatternResolver.getResources(packageSearchPath));
        //设置datasource
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        Map<String,Object> properties=new HashMap<>();
        properties.put(DruidDataSourceFactory.PROP_DRIVERCLASSNAME,driverClassName);
        properties.put(DruidDataSourceFactory.PROP_URL,dbUrl);
        properties.put(DruidDataSourceFactory.PROP_USERNAME,userName);
        properties.put(DruidDataSourceFactory.PROP_PASSWORD,password);
        properties.put(DruidDataSourceFactory.PROP_VALIDATIONQUERY,validationQuery);
        properties.put(DruidDataSourceFactory.PROP_VALIDATIONQUERY_TIMEOUT,validationQueryTimeout);
        properties.put(DruidDataSourceFactory.PROP_TESTONBORROW,testOnBorrow);
        //添加统计、SQL注入、日志过滤器
        properties.put(DruidDataSourceFactory.PROP_FILTERS,"stat,wall,log4j2");
        //sql合并，慢查询定义为5s
        properties.put(DruidDataSourceFactory.PROP_CONNECTIONPROPERTIES,"druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000");
        try {
            return DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
