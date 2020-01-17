package com.biz.rbooks.config;


import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan("com.biz.rbooks.repository")
public class MybatisConfig {

	@Bean
	public DataSource oracleDs() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("bookuser");
		ds.setPassword("bookuser");
		return ds;
	}
	
	@Bean
	public SqlSessionFactoryBean sqlFactory() {
		SqlSessionFactoryBean sb = new SqlSessionFactoryBean();
		sb.setDataSource(oracleDs());
		sb.setTypeAliasesPackage("com.biz.rbooks.domain");
		return sb;
	}
	
	@Bean
	public DataSourceTransactionManager tm() {
		DataSourceTransactionManager tm = new DataSourceTransactionManager(oracleDs());
		return tm;
	}
	
}
