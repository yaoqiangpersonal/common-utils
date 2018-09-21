package com.yq.blueray.taobao.config.data;

import com.alibaba.druid.pool.DruidDataSource;
import com.yq.blueray.common.base.impl.config.AbstractMultipleDataSourceConfig;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Auther: yq
 * @Date: 2018-09-12 18:21
 * @Description:
 */

// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = SqlServerDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "slaveSqlSessionFactory")
public class SqlServerDataSourceConfig extends AbstractMultipleDataSourceConfig {

    // 精确到 master 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.yq.blueray.taobao.mapper.sqlserver";

    protected String mapperLocation;

    public SqlServerDataSourceConfig(@Value("${spring.datasource.sqlserver.mapper-location}")String mapperLocation) {
        super(mapperLocation);
    }

    @Bean(name = "slaveDataSource")
    @Qualifier("slaveDataSource")
    @ConfigurationProperties("spring.datasource.sqlserver")
    public DataSource dataSource() {
        return super.dataSource();
    }

    @Bean(name = "slaveTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager() {
        return super.dataSourceTransactionManager();
    }

    @Bean(name = "slaveSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("slaveDataSource") DataSource dataSource)
            throws Exception {
        return super.sqlSessionFactory(dataSource);
    }
}
