package org.springframework.social.fivepx.api.impl;

import org.springframework.social.fivepx.api.OperationResult;
import org.springframework.social.fivepx.api.Photo;
import org.springframework.social.fivepx.api.PhotoImageSize;
import org.springframework.social.fivepx.api.PhotoOperations;
import org.springframework.social.fivepx.api.PhotoResult;
import org.springframework.social.fivepx.api.PhotoSearchResult;
import org.springframework.social.fivepx.api.PhotoSearchResult.Sort;
import org.springframework.social.fivepx.api.PhotoStream;
import org.springframework.social.fivepx.api.PhotoStreamResult;
import org.springframework.social.fivepx.api.UserStream;
import org.springframework.util.MultiValueMap;

/**
 * @author Daniel Rochetti
 */
public class PhotoTemplate extends AbstractFivepxOperations implements PhotoOperations {

	public PhotoTemplate(final FivepxTemplate fivepxTemplate) {
		super(fivepxTemplate);
	}

	@Override
	public Photo getPhoto(Long photoId) {
		return getPhoto(photoId, null, null, null, null).getPhoto();
	}

	@Override
	public Photo getPhoto(Long photoId, PhotoImageSize imageSize) {
		return getPhoto(photoId, null, null, null, imageSize).getPhoto();
	}

	@Override
	public PhotoResult getPhoto(Long photoId, Boolean comments, Integer commentsPage,
			Boolean tags, PhotoImageSize imageSize) {
		MultiValueMap<String, String> params = params(
				"comments", comments,
				"comments_page", commentsPage,
				"tags", tags,
				"image_size", imageSize != null ? imageSize.getId() : null);
		return getRestTemplate().getForObject(buildUri("{id}", params, urlVariables("id", photoId)), PhotoResult.class);
	}

	@Override
	public PhotoStreamResult getPhotos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PhotoStreamResult getPhotos(PhotoStream stream) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PhotoStreamResult getPhotos(UserStream stream, Long userId,
			String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PhotoStreamResult getPhotos(PhotoStream stream, Sort sort,
			Integer page, Integer resultsToReturn, Boolean includeStore,
			Boolean includeState, Boolean tags, PhotoImageSize... imageSizes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PhotoStreamResult getPhotos(UserStream stream, Long userId,
			String username, Sort sort, Integer page, Integer resultsToReturn,
			Boolean includeStore, Boolean includeState, Boolean tags,
			PhotoImageSize... imageSizes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PhotoSearchResult searchByKeywords(String term) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PhotoSearchResult searchByTag(String tag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OperationResult addToFavorites(Long photoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OperationResult removeFromFavorites(Long photoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OperationResult like(Long photoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OperationResult dislike(Long photoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getEndpointPath() {
		return "photos/";
	}

}
