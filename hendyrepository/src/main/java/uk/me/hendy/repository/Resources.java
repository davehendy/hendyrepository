package uk.me.hendy.repository;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

//import org.springframework.test.context.ContextConfiguration;
//@ContextConfiguration
public class Resources {
	@PersistenceContext
	static private EntityManager entityManager;
	
	static public EntityManager getEntityManager() {
		return entityManager;
	}

}
