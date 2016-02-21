package uk.me.hendy.hendyrepository;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import uk.me.hendy.repository.RepositoryApplication;
import uk.me.hendy.repository.RepositoryApplicationFactory;
import uk.me.hendy.repository.hendycam.model.HendyCamImage;

public class TestHendyCam {

	static RepositoryApplication app;
	@Before
	public void setUp() throws Exception {
		app=RepositoryApplicationFactory.getInstance();
	}

	@Test
	public void test() {
		List<HendyCamImage> list = app.getHendyCamImages();
		for (HendyCamImage image : list) {
			System.out.println ("date="+ image.getDateCreated() + ";path="+image.getPath());
		}
	}

}
