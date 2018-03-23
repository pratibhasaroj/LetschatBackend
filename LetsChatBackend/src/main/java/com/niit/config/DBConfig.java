package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.BlogDao;
import com.niit.daoImpl.BlogDaoImpl;
//import com.niit.daoImpl.BlogDaoImpl;
import com.niit.model.Blog;
import com.niit.model.Forum;
import com.niit.model.Job;
import com.niit.model.User;


@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class DBConfig {
	
   @Bean(name = "dataSource")
	public DataSource getH2DataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		return dataSource;

	}

    

    private Properties getHibernateProperties() {
    	Properties properties = new Properties();
    	properties.setProperty("hibernate.hbm2ddl.auto", "update");
    	properties.put("hibernate.show_sql", "true");
    	//properties.put("hibernate.format_sql", "true");
    	properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
    	return properties;
    }

    

    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    	sessionBuilder.addProperties(getHibernateProperties());
    	sessionBuilder.addAnnotatedClass(Blog.class);
    	sessionBuilder.addAnnotatedClasses(Forum.class);
        sessionBuilder.addAnnotatedClass(Job.class);
    	sessionBuilder.addAnnotatedClass(User.class);
    	//SessionFactory sessionFactory = sessionBuilder.buildSessionFactory();
		System.out.println("<---------Session object created--------->");
		return sessionBuilder.buildSessionFactory();
    }

   

    @Bean(name="blogDao")
	public BlogDaoImpl getBlogDao(SessionFactory sessionfactory){
		
		return new BlogDaoImpl(sessionfactory);
	
	}
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
			SessionFactory sessionFactory) {
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
			return transactionManager;

	}
	/*
	public DataSource getDataSource(){
		
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");
		datasource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		datasource.setUsername("sa");
		datasource.setPassword("sa");
		return datasource;
		
	}
	
	//sessionfactory bean
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionfactory(){
		
		Properties hibernatePro=new Properties();
		hibernatePro.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		hibernatePro.put("hiberante.hbm2ddl.auto","update");
	    hibernatePro.put("hibernate.show_sql", "true");
		LocalSessionFactoryBuilder sessionFactoryBuilder=new LocalSessionFactoryBuilder(getDataSource());
		sessionFactoryBuilder.addProperties(hibernatePro);
		sessionFactoryBuilder.addAnnotatedClass(Blog.class);
		//System.out.println("Table is created");
		SessionFactory sessionFactory=sessionFactoryBuilder.buildSessionFactory();
		System.out.println("Session factory object is created");
		
		return sessionFactory;
		
	}
	
	@Bean(name="blogDaoImpl")
	public BlogDaoImpl getBlogDao(SessionFactory sessionfactory){
		
		return new BlogDaoImpl(sessionfactory);
	
	}

	
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionfactory){
		HibernateTransactionManager tm=new HibernateTransactionManager(sessionfactory);
		return tm;
	}
	*/
	/*@Bean(name="blogDaoImpl")
	public BlogDaoImpl getBlogDao(SessionFactory sessionfactory){
		
		return new BlogDaoImpl(sessionfactory);
	
	
	@Bean(name="userDaoImpl")
	public UserDaoImpl getUserDao(SessionFactory sessionfactory){
		
		return new UserDaoImpl(sessionfactory);
	
}}*/
}
