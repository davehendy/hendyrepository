package uk.me.hendy.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RepositoryApplicationFactory {
	
	
	@Autowired
	private RepositoryApplication instance = null;
	
	private void createInstance() {
		if (instance == null) {
			System.out.println("Creating Repository Application Context");
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JpaConfigurationMySql.class);
			
			instance = ((RepositoryApplicationFactory) context.getBean("repositoryApplicationFactory")).getInstance();
		} else {
			System.out.println("Already created");
		}
	}

	public RepositoryApplication getInstance() {
		if (instance == null) {
			createInstance();
		}
		return instance;
	}
	

}
