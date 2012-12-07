package org.springframework.social.fivepx.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.social.fivepx.api.Photo;
import org.springframework.social.fivepx.api.PhotoOperations;

public class PhotoOperationsTest extends FivepxBaseTest {

	private PhotoOperations photoOperations;

	@Before
	public void init() {
		photoOperations = fivepxApi.photoOperations();
		assertNotNull(photoOperations);
	}

	@Test
	public void testGetPhoto() {
		final Long id = 19358511L;
		Photo photo = photoOperations.getPhoto(id);
		assertEquals(id, photo.getId());
		assertNotNull(photo);
	}

}
