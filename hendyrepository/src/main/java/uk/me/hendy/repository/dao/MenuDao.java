package uk.me.hendy.repository.dao;

import java.util.List;

import uk.me.hendy.repository.model.Menu;

public interface MenuDao {
	Menu findById(String id);
	List<Menu> getList();
	void create(Menu menu);
	void remove(Menu menu);
	void update(Menu menu);
}
