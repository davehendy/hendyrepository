package uk.me.hendy.repository.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import uk.me.hendy.repository.dao.MenuDao;
import uk.me.hendy.repository.model.Menu;

@Repository
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class MenuDaoJpa implements MenuDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private static final Logger logger = LoggerFactory.getLogger(MenuDaoJpa.class);

	public Menu findById(String id) throws EntityNotFoundException {
		logger.debug("method findById(" + id + ")");
		Menu menu = entityManager.find(Menu.class, id);
		return menu;
	}
	
	public List<Menu> getList() {
		logger.debug("method getList()");
		//Query q = entityManager.createQuery("select c from Menu c");
		TypedQuery<Menu> tq = entityManager.createQuery("select c from Menu c", Menu.class);
	    List<Menu> menuList = tq.getResultList();
	    System.out.println("data fetched");
		//entityManager.flush();
		// Otherwise the query returns the existing order (and we didn't set the
		// parent in the item)...
		//entityManager.clear();
		return menuList;
	}
	

	@Transactional(propagation=Propagation.MANDATORY,readOnly=false)
	public void create(Menu menu) {
		entityManager.persist(menu);
	}
	
	@Transactional(propagation=Propagation.MANDATORY,readOnly=false)
	public void remove(Menu menu) {
		entityManager.remove(entityManager.contains(menu) ? menu : entityManager.merge(menu));
	}

	@Transactional(propagation=Propagation.MANDATORY,readOnly=false)
	public void update(Menu menu) {
		entityManager.merge(menu);
	}

}
