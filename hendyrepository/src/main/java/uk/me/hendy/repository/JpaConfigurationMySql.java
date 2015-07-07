package uk.me.hendy.repository;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.spi.PersistenceProvider;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import uk.me.hendy.repository.dao.MenuDao;
import uk.me.hendy.repository.dao.impl.MenuDaoJpa;
//import org.hibernate.cache.HashtableCacheProvider;

@Configuration
@EnableTransactionManagement
@PropertySource(value="classpath:/hendyrepository-${user.name}.properties")
public class JpaConfigurationMySql {
	
	@Autowired
	private Environment environment;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		  return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(environment.getProperty("drg.db.driver"));
		ds.setUrl(environment.getProperty("drg.db.url"));
		ds.setUsername(environment.getProperty("drg.db.user"));
		ds.setPassword(environment.getProperty("drg.db.pass"));
		ds.setInitialSize(new Integer(environment.getProperty("drg.db.initSize")));
		ds.setTestWhileIdle(true);
		ds.setTimeBetweenEvictionRunsMillis(10000);
		return ds;
		/*
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		//dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		//dataSource.setUrl("jdbc:mysql://localhost/hendymeu_content");
		//dataSource.setUsername("drgh");
		//dataSource.setPassword("xxxx");
		dataSource.setDriverClassName(environment.getProperty("drg.db.driver"));
		dataSource.setUrl(environment.getProperty("drg.db.url"));
		dataSource.setUsername(environment.getProperty("drg.db.user"));
		dataSource.setPassword(environment.getProperty("drg.db.pass"));
		//dataSource.
		
		
		return dataSource;
		*/
	}

	@Bean
	public Map<String, Object> jpaProperties() {
		Map<String, Object> props = new HashMap<String, Object>();
		props.put("hibernate.hbm2ddl.auto", "validate"); //This stops hibernate creating creating tables/columns, etc
		//props.put("hibernate.dialect", H2Dialect.class.getName());
		//props.put("hibernate.cache.provider_class", HashtableCacheProvider.class.getName());
		return props;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(true);
		hibernateJpaVendorAdapter.setGenerateDdl(true);
		hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
		return hibernateJpaVendorAdapter;
	}
	
	@Bean HibernateJpaDialect hibernateJpaDialect() {
		return new HibernateJpaDialect();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		
		txManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
		//txManager.setDataSource(dataSource());
		txManager.setJpaDialect(hibernateJpaDialect());
		return txManager;
		//return new JpaTransactionManager( localContainerEntityManagerFactoryBean().getObject() );
	}
	
	@Bean
	public PersistenceProvider persistenceProvider() {
		return new org.hibernate.jpa.HibernatePersistenceProvider();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
		lef.setDataSource(this.dataSource());
		lef.setJpaPropertyMap(this.jpaProperties());
		lef.setJpaVendorAdapter(this.jpaVendorAdapter());
		lef.setPersistenceProvider(this.persistenceProvider());
		lef.setPackagesToScan(new String[] { "uk.me.hendy.repository.model" });
		
		return lef;
	}
	
	
	@Bean
	public MenuDao menuDao() {
		return new MenuDaoJpa();
	}
	
	
	@Bean
	public RepositoryApplication repositoryApplication() {
		return new RepositoryApplicationHibernateMySql();
	}
	

	/*
	@Bean RepositoryApplicationFactory repositoryApplicationFactory() {
		RepositoryApplicationFactory appFact = new RepositoryApplicationFactory();
		return appFact;
		//return new RepositoryApplicationFactory();
	}
	*/
	
	/*
	@Bean
	public PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor() {
		return new PersistenceAnnotationBeanPostProcessor();
	}
	*/

}
