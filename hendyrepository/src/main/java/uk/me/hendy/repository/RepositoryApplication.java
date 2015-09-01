package uk.me.hendy.repository;

import java.util.List;

import uk.me.hendy.repository.hendycam.model.HendyCamImage;
import uk.me.hendy.repository.model.Menu;

public interface RepositoryApplication {
	
	public List<Menu> getMenuList();
	public Menu getMenu(String name);
	public void createMenu(Menu menu);
	public void removeMenu(Menu menu);
	public void updateMenu(Menu menu);
	
	public List<HendyCamImage> getHendyCamImages();

}
