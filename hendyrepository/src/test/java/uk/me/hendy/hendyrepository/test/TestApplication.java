package uk.me.hendy.hendyrepository.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import uk.me.hendy.repository.JpaConfigurationMySql;
import uk.me.hendy.repository.dao.MenuDao;
import uk.me.hendy.repository.dao.impl.MenuDaoJpa;
import uk.me.hendy.repository.model.Menu;

@Configuration
@ComponentScan
public class TestApplication {

	public static void main(String[] args) {
		System.out.println("Start Test2");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JpaConfigurationMySql.class);
		MenuDao menuDao = context.getBean(MenuDao.class);
		
		System.out.println("insert starts=====");
		Menu menu = new Menu();
		menu.setName("drrrr");
		menu.setDescription("tetetststtsts");
		menuDao.create(menu);
		context.close();
	}

}
