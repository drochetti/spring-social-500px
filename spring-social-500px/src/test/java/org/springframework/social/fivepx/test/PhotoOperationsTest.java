package org.springframework.social.fivepx.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;
import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.fivepx.api.Photo;
import org.springframework.social.fivepx.api.PhotoCategory;
import org.springframework.social.fivepx.api.PhotoOperations;
import org.springframework.social.fivepx.api.PhotoSearchFilter;
import org.springframework.social.fivepx.api.PhotoSearchResult;
import org.springframework.social.fivepx.api.PhotoStream;
import org.springframework.social.fivepx.api.PhotoStreamFilter;
import org.springframework.social.fivepx.api.PhotoStreamResult;

public class PhotoOperationsTest extends FivepxBaseTest {

	private static final int DEFAULT_RPP = 20;

	private static final Long TEST_PHOTO_ID = 19358511L;

	private PhotoOperations photoOperations;

	@Before
	public void init() {
		photoOperations = fivepxApi.photoOperations();
		assertNotNull(photoOperations);
	}

	@Test
	public void testGetPhoto() {
		Photo photo = photoOperations.getPhoto(TEST_PHOTO_ID);
		assertNotNull(photo);
		assertEquals(TEST_PHOTO_ID, photo.getId());
	}
	
	@Test
	public void testGetPhotoPopularBlackAndWhiteStream() {
		final PhotoStream stream = PhotoStream.POPULAR;
		final PhotoCategory bnw = PhotoCategory.BLACK_AND_WHITE;

		PhotoStreamResult result = photoOperations.getPhotos(
				PhotoStreamFilter.by(stream).withOnly(bnw).withExclude(PhotoCategory.NUDE));
		assertNotNull(result);
		assertTrue(stream.equals(result.getStream()));
		assertTrue(bnw.equals(result.getFilters().getCategory()));
		List<Photo> photos = result.getPhotos();
		assertTrue(photos.size() <= DEFAULT_RPP);
	}

	@Test
	public void testSearchByKeywords() {
		PhotoSearchResult result = photoOperations.search(PhotoSearchFilter.byKeywords("rio de janeiro"));
		assertNotNull(result);
		List<Photo> photos = result.getPhotos();
		assertTrue(photos.size() <= DEFAULT_RPP);
	}
	
	@Test
	public void testSearchByTag() {
		final String tag = "sunset";
		final Integer rrp = 10;

		PhotoSearchResult result = photoOperations.search(PhotoSearchFilter.byTag(tag).withResultsPerPage(rrp));
		assertNotNull(result);
		List<Photo> photos = result.getPhotos();
		assertTrue(photos.size() <= rrp);
		for (Photo photo : photos) {
			Set<String> tags = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
			tags.addAll(photo.getTags());
			assertTrue(tags.contains(tag));
		}
	}

	@Test(expected = MissingAuthorizationException.class)
	public void testAddToFavorites() {
		photoOperations.addToFavorites(TEST_PHOTO_ID);
	}
	
	@Test(expected = MissingAuthorizationException.class)
	public void testRemoveFromFavorites() {
		photoOperations.removeFromFavorites(TEST_PHOTO_ID);
	}

}
