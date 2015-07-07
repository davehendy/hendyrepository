package uk.me.hendy;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import uk.me.hendy.repository.Resources;
import uk.me.hendy.repository.model.Menu;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class MenuPersistenceTests {

	
	private EntityManager entityManager;

	@Test
	@Transactional
	public void testGetMenu() throws Exception {
		entityManager = Resources.getEntityManager();
		Query q = entityManager.createQuery("select c from Menu c");
	    List<Menu> menuList = q.getResultList();
	    for (Menu menu : menuList) {
	    	System.out.println("Menu="+menu);
	    }
		entityManager.flush();
		// Otherwise the query returns the existing order (and we didn't set the
		// parent in the item)...
		entityManager.clear();
		
	}

	

}
