package com.okayo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:properties/database.properties" }) 
@ComponentScan({"com.okayo.dao","com.okayo.model","com.okayo.service"})
public class Config {
 	
    @Bean
    public DataSource dataSource()  {
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
    	dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    	dataSource.setUrl("jdbc:mysql://localhost:3306/okayo");
    	dataSource.setUsername("root");
    	dataSource.setPassword("");
        return dataSource;
    }
    
    @Bean @Autowired
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setPackagesToScan("com.okayo.model");
		bean.setHibernateProperties(hibernateProperties());
		
		return bean;
	}

	@Bean @Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
      HibernateTransactionManager txManager = new HibernateTransactionManager();
	  txManager.setSessionFactory(sessionFactory);
	 
	  return txManager;
	}
	
	private Properties hibernateProperties() {
		Properties props = new Properties();
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.format_sql", "true");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		
		return props;
	}

}
