package uk.me.hendy.repository;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import uk.me.hendy.repository.dao.MenuDao;
import uk.me.hendy.repository.hendycam.dao.HendyCamDao;
import uk.me.hendy.repository.hendycam.model.HendyCamImage;
import uk.me.hendy.repository.model.Menu;

public class RepositoryApplicationHibernateMySql implements
		RepositoryApplication {
	private static final Logger logger = LoggerFactory.getLogger(RepositoryApplicationHibernateMySql.class);
	@Autowired
	MenuDao menuDao;
	
	@Autowired
	HendyCamDao hendyCamDao;

	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<Menu> getMenuList() {
		logger.debug("getMenuList");
		return menuDao.getList();
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public Menu getMenu(String name) {
		logger.debug("getMenu("+name+")");
		return menuDao.findById(name);
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void createMenu(Menu menu) {
		logger.debug("createMenu("+menu+")");
		menuDao.create(menu);
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void removeMenu(Menu menu) {
		menuDao.remove(menu);
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void updateMenu(Menu menu) {
		logger.debug("updateMenu("+menu+")");
		menuDao.update(menu);
	}
	
	public List<HendyCamImage> getHendyCamImages() {
		logger.debug("getHendyCamImages()");
		return hendyCamDao.getAll();
	}

}
