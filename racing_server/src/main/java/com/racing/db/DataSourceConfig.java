package com.racing.db;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DataSourceConfig implements EnvironmentAware {

  private RelaxedPropertyResolver propertyResolver;

  private static Logger log = LoggerFactory.getLogger(DataSourceConfig.class);

  @Override
  public void setEnvironment(Environment env) {
    this.propertyResolver = new RelaxedPropertyResolver(env, "datasource.");
  }

  @Bean(name = "dataSource", destroyMethod = "close", initMethod = "init")
  @Primary
  public DataSource mysqlDataSource() {
    log.debug("Configruing mysql DataSource");
    return this.createEnvDataSource("mysql");
  }

  private DruidDataSource createEnvDataSource(String dbType) {
    DruidDataSource datasource = new DruidDataSource();
    datasource.setUrl(propertyResolver.getProperty(dbType + ".url"));
    datasource.setDriverClassName(propertyResolver.getProperty(dbType + ".driverClassName"));
    datasource.setUsername(propertyResolver.getProperty(dbType + ".username"));
    datasource.setPassword(propertyResolver.getProperty(dbType + ".password"));
    datasource.setInitialSize(Integer.parseInt(propertyResolver.getProperty(dbType + ".initialSize")));
    datasource.setMaxActive(Integer.parseInt(propertyResolver.getProperty(dbType + ".maxActive")));
    datasource.setMaxWait(Long.valueOf(propertyResolver.getProperty(dbType + ".maxWait")));
    datasource.setMinIdle(Integer.parseInt(propertyResolver.getProperty(dbType + ".minIdle")));
    datasource.setValidationQuery(propertyResolver.getProperty(dbType + ".validationQuery"));
    return datasource;
  }

}
