package uk.me.hendy.repository.hendycam.dao.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Value;

import uk.me.hendy.repository.hendycam.dao.HendyCamDao;
import uk.me.hendy.repository.hendycam.model.HendyCamImage;

public class HendyCamDaoDefault implements HendyCamDao  {

	@Value("${drg.hendycam.loc}")
	private String hendyCamLoc;
	
	public List<HendyCamImage> getAll() {
		//Get the HendyCam directory
		File f = new File(hendyCamLoc);
		File [] fileList = f.listFiles();
		SortedSet<HendyCamImage> imageSet = new TreeSet<HendyCamImage>(
				new Comparator<HendyCamImage>() {
					public int compare(HendyCamImage o1, HendyCamImage o2) {
						return o1.getDateCreated().compareTo(o2.getDateCreated());
					}
					
				}
				);
		for (File file : fileList) {
			HendyCamImage image = new HendyCamImage();
			image.setName(file.getName());
			image.setPath(file.getPath());
			Calendar cal=Calendar.getInstance();
			cal.setTimeInMillis(file.lastModified());
			image.setDateCreated(cal.getTime());
			imageSet.add(image);
		}
		
		return new ArrayList<HendyCamImage>(imageSet);
	}

}
