package com.aditya.SportsMarketBackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"com.aditya.SportsMarketBackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {

	private final static String DB_URL="jdbc:h2:tcp://localhost/~/eshop";
	private final static String DB_DRIVER="org.h2.Driver";
	private final static String DB_DIALECT="org.hibernate.dialect.H2Dialect";
	private final static String DB_USERNAME="Aditya";
	private final static String DB_PASSWORD="aditya";
	
	@Bean
	public DataSource getDataSource(){
		BasicDataSource datasource=new BasicDataSource();
		
		datasource.setDriverClassName(DB_DRIVER);
		datasource.setUrl(DB_URL);
		datasource.setUsername(DB_USERNAME);
		datasource.setPassword(DB_PASSWORD);
		
		
		return datasource;
	}
	
	@Bean
	public SessionFactory getSessionFactory(DataSource datasource)
	{
		
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(datasource);
		
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.aditya.SportsMarketBackend.dto");
		return builder.buildSessionFactory();
	}

	private Properties getHibernateProperties() {
	
		Properties properties=new Properties();
		properties.put("hibernate.dialect",DB_DIALECT);
		properties.put("hibernate.show_sql","true");
		properties.put("hibernate.fomat_sql","true");
		
		
		return properties;
	}
	
	@Bean
	 public HibernateTransactionManager getTransactionManager(SessionFactory sessionfactory)
	{
	  HibernateTransactionManager transactionmanager=new HibernateTransactionManager(sessionfactory);
	  return transactionmanager;
	}
	
}
