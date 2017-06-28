package com.wangdh.spring.cache.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
import com.wangdh.mybatis.base.MSSQLMapper;

/**
 * mybatis相关配置
 * @author wangdh
 * 2017年6月27日下午1:56:57
 */
@Configuration
public class MybatisConfig {
	
	@Bean
	public DataSource dataSource(){
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl("jdbc:sqlserver://127.0.0.17:1433;databasename=MybatisDB;");
		dataSource.setUsername("sa");
		dataSource.setPassword("1q2w#E$R");
		dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws Exception{
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactory.setMapperLocations(resolver.getResources("classpath*:mapper/*.xml"));
		
		sqlSessionFactory.setDataSource(dataSource);
		sqlSessionFactory.setTypeAliasesPackage("com.wangdh.mybatis.mapper.entity");
		
		return sqlSessionFactory;
	}
	
	@Bean
    public DataSourceTransactionManager txManager(DataSource dataSource) {
    	return new DataSourceTransactionManager(dataSource);
    }
	
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() throws Exception{
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setBasePackage("com.wangdh.mybatis.mapper");
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		mapperScannerConfigurer.setMarkerInterface(MSSQLMapper.class);
		
		return mapperScannerConfigurer;
	}
}
