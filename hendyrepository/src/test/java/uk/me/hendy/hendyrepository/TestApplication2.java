package uk.me.hendy.hendyrepository;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import uk.me.hendy.repository.JpaConfigurationMySql;
import uk.me.hendy.repository.RepositoryApplication;
import uk.me.hendy.repository.RepositoryApplicationFactory;
import uk.me.hendy.repository.model.Menu;

@Configuration
@ComponentScan
public class TestApplication2 {

	public static void main(String[] args) {
		System.out.println("Start Test");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JpaConfigurationMySql.class);
		Environment env = context.getBean(Environment.class);
		System.out.println("env="+env);
		//RepositoryApplicationFactory fact = (RepositoryApplicationFactory) context.getBean("repositoryApplicationFactory");
		RepositoryApplication app = RepositoryApplicationFactory.getInstance();
		
		
		List<Menu> menuList = app.getMenuList();
		for (Menu menu : menuList) {
	    	System.out.println("Menu="+menu);
	    }
		System.out.println("====again=====");
		Menu menu = app.getMenu("davetest");
		System.out.println("menu="+menu);
		
		System.out.println("insert starts=====");
		menu = new Menu();
		menu.setName("drrrr");
		menu.setDescription("tetetststtsts");
		app.createMenu(menu);
		context.close();
	}

}
