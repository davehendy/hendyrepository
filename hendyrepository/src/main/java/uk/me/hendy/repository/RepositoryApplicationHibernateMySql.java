package uk.me.hendy.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import uk.me.hendy.repository.dao.MenuDao;
import uk.me.hendy.repository.model.Menu;

public class RepositoryApplicationHibernateMySql implements
		RepositoryApplication {
	@Autowired
	MenuDao menuDao;

	public List<Menu> getMenuList() {
		return menuDao.getList();
	}
	
	public Menu getMenu(String name) {
		return menuDao.findById(name);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void createMenu(Menu menu) {
		menuDao.create(menu);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void removeMenu(Menu menu) {
		menuDao.remove(menu);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void updateMenu(Menu menu) {
		menuDao.update(menu);
	}

}
