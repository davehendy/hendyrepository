package uk.me.hendy.repository.hendycam.dao;

import java.util.List;

import uk.me.hendy.repository.hendycam.model.HendyCamImage;

public interface HendyCamDao {
	
	List<HendyCamImage> getAll();

}
