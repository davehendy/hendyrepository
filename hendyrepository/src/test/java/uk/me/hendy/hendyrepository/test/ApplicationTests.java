package uk.me.hendy.hendyrepository.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import uk.me.hendy.repository.RepositoryApplication;
import uk.me.hendy.repository.RepositoryApplicationFactory;
import uk.me.hendy.repository.model.Menu;
import uk.me.hendy.repository.model.MenuItem;

public class ApplicationTests {
	
	static RepositoryApplication app;
	
	@BeforeClass
	public static void getRepositoryApplication() {
		RepositoryApplicationFactory fact = new RepositoryApplicationFactory();
		app = fact.getInstance(); //RepositoryApplicationFactory.getInstance();
	}
	
	@Test
	public void testCreate() {
		System.out.println("Running testCreate");
		Menu menu = new Menu();
		menu.setName("davemenu");
		menu.setDescription("created by Dave in jpa");
		menu.setLinkUrl("hendy.me.uk");
		//---
		Set<MenuItem> menuItemSet = new HashSet<MenuItem>();
		MenuItem menuItem = new MenuItem();
		menuItem.setMenuName("davemenu");
		menuItem.setMenuSeq(2);
		menuItem.setName("item 1");
		menuItem.setLinkUrl("link test");
		menuItemSet.add(menuItem);
		menu.setMenuItemSet(menuItemSet);
		//---
		app.createMenu(menu);
	}
	
	@Test
	public void testRemove() {
		System.out.println("Running testRemove");
		Menu menu = app.getMenu("davecreate");
		app.removeMenu(menu);
	}
	
	@Test
	public void testUpdate() {
		System.out.println("Running testUpdate");
		Menu menu = app.getMenu("davemenu");
		menu.setDescription("updated 1");
		//---
		//Set<MenuItem> menuItemSet = menu.getMenuItemSet();
		Set<MenuItem> menuItemSet = new HashSet();
		for(MenuItem menuItem : menuItemSet) {
			
		}
		MenuItem menuItem = new MenuItem();
		menuItem.setMenuName("davemenu");
		menuItem.setMenuSeq(6);
		menuItem.setName("item 6");
		menuItem.setLinkUrl("link test 5a");
		menuItemSet.add(menuItem);
		menu.setMenuItemSet(menuItemSet);
		//menu.getMenuItemSet().add(menuItem);
		app.updateMenu(menu);
	}

	@Test
	public void testFetch() {
		System.out.println("Running testFetch");
		List<Menu> menuList = app.getMenuList();
		for (Menu menu : menuList) {
	    	System.out.println("Menu="+menu);
	    }
		System.out.println("----next----");
		Menu menu = app.getMenu("davetest");
		Set<MenuItem> menuItemSet = menu.getMenuItemSet();
		System.out.println("menu=" + menu);
		
		for (MenuItem menuItem : menuItemSet) {
			System.out.println("Item="+menuItem.getName());
		}
	}
	
	

}
