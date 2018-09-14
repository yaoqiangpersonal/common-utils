package com.yq.blueray.common.base.impl.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.yq.blueray.common.base.MultipleDataSourceConfig;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;

import org.springframework.boot.jdbc.DataSourceBuilder;

import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Auther: yq
 * @Date: 2018-09-13 12:12
 * @Description:
 */
public abstract class AbstractMultipleDataSourceConfig implements MultipleDataSourceConfig {

    private final String mapperLocation;


    public AbstractMultipleDataSourceConfig(String mapperLocation) {
        this.mapperLocation = mapperLocation;
    }

    @Override
    public DataSource dataSource() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    @Override
    public DataSourceTransactionManager dataSourceTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Override
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources(mapperLocation));
        return sessionFactory.getObject();
    }
}
