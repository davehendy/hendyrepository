package uk.me.hendy.hendyrepository.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import uk.me.hendy.repository.RepositoryApplication;
import uk.me.hendy.repository.RepositoryApplicationFactory;
import uk.me.hendy.repository.dao.MenuDao;
import uk.me.hendy.repository.model.Menu;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=uk.me.hendy.repository.JpaConfigurationMySql.class)
public class TestApplication {
	
	RepositoryApplication app;
	//@Autowired
	//RepositoryApplicationFactory repositoryApplicationFactory;

	@Test
	public void testCreate() {
		System.out.println("Start Test2");
		app=RepositoryApplicationFactory.getInstance();
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JpaConfigurationMySql.class);
		
		
		System.out.println("insert starts=====");
		Menu menu = new Menu();
		menu.setName("drrrr");
		menu.setDescription("tetetststtsts");
		app.createMenu(menu);
		//context.close();
	}

}
