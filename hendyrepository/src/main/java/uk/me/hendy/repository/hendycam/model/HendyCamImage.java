package uk.me.hendy.repository.hendycam.model;

import java.util.Date;

public class HendyCamImage {
	
	private Date dateCreated;
	private String name;
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
