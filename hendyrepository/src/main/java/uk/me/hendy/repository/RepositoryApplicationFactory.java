package uk.me.hendy.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class RepositoryApplicationFactory {
	
	private static final Logger logger = LoggerFactory.getLogger(RepositoryApplicationFactory.class);
	//@Autowired
	private static RepositoryApplication repositoryApplication;
	private static AnnotationConfigApplicationContext context;
	@PersistenceContext
	private EntityManager entityManager;
	
	private static void createInstance() {
		logger.info("createInstance");
		if (repositoryApplication == null) {
			logger.info("Creating Repository Application Context");
			context = new AnnotationConfigApplicationContext(JpaConfigurationMySql.class);

			
			//((RepositoryApplicationFactory) context.getBean("repositoryApplicationFactory")).getInstance();
			repositoryApplication = (RepositoryApplication)context.getBean("repositoryApplication");
			
		} else {
			logger.info("Repository Application already created");
		}
		
	}

	public static RepositoryApplication getInstance() {
		if (repositoryApplication == null) {
			createInstance();
		} else {
			logger.info("Repository Application instance already exists - return that");
		}
		
		return repositoryApplication;
	}
	
	public static void closeApplication() {
				
		logger.info("Closing Spring application context " + context);
		context.stop();
		context.close();
		repositoryApplication = null;
		
	}
	

}
