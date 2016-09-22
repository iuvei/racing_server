package com.racing.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.racing.db.DataSourceConfig;

@Configuration
@AutoConfigureAfter({DataSourceConfig.class})
public class MybatisConfiguration {

  private static Logger logger = LoggerFactory.getLogger(MybatisConfiguration.class);

  @Bean(name = "sqlSessionFactory")
  public SqlSessionFactory mysqlSqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) {
    try {
      SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
      sessionFactory.setDataSource(dataSource);
      sessionFactory.setTypeAliasesPackage("com.racing.model.po");
      sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:com/racing/model/mapper/xml/*.xml"));
      return sessionFactory.getObject();
    } catch (Exception e) {
      logger.warn("Could not confiure mybatis session factory");
      return null;
    }
  }

  @Bean(name = "mapperScannerConfigurer")
  public MapperScannerConfigurer mysqlMapperScannerConfigurer() {
    MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
    mapperScannerConfigurer.setBasePackage("com.racing.model.mapper");
    mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
    return mapperScannerConfigurer;
  }


}
