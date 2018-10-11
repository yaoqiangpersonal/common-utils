package com.yq.blueray.config.data;

import com.yq.blueray.common.base.impl.config.AbstractMultipleDataSourceConfig;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Auther: yq
 * @Date: 2018-09-12 18:20
 * @Description:
 */

// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = MasterDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataSourceConfig extends AbstractMultipleDataSourceConfig {

    // 精确到 master 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.yq.blueray.taobao.mapper.blueray";


    public MasterDataSourceConfig(
            @Value("${spring.datasource.blueray.mapper-location}") String mapperLocation) {
        super(mapperLocation);
    }

    @Override
    @Bean(name = "masterDataSource")
    @Qualifier("masterDataSource")
    @Primary
    @ConfigurationProperties("spring.datasource.blueray")
    public DataSource dataSource() {
        return super.dataSource();
    }

    @Bean(name = "masterTransactionManager")
    @Primary
    public DataSourceTransactionManager dataSourceTransactionManager() {
        return super.dataSourceTransactionManager();
    }

    @Bean(name = "masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("masterDataSource") DataSource dataSource)
            throws Exception {
       return super.sqlSessionFactory(dataSource);
    }

}
