package uk.me.hendy.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import uk.me.hendy.repository.dao.MenuDao;
import uk.me.hendy.repository.model.Menu;

public class RepositoryApplicationHibernateMySql implements
		RepositoryApplication {
	private static final Logger logger = LoggerFactory.getLogger(RepositoryApplicationHibernateMySql.class);
	@Autowired
	MenuDao menuDao;

	public List<Menu> getMenuList() {
		logger.debug("getMenuList");
		return menuDao.getList();
	}
	
	public Menu getMenu(String name) {
		logger.debug("getMenu("+name+")");
		return menuDao.findById(name);
	}
	
	public void createMenu(Menu menu) {
		menuDao.create(menu);
	}
	
	public void removeMenu(Menu menu) {
		menuDao.remove(menu);
	}
	
	public void updateMenu(Menu menu) {
		menuDao.update(menu);
	}

}
