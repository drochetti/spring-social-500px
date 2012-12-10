package org.springframework.social.fivepx.api.impl;

import java.net.URI;

import org.springframework.social.fivepx.api.OperationResult;
import org.springframework.social.fivepx.api.Photo;
import org.springframework.social.fivepx.api.PhotoFilter;
import org.springframework.social.fivepx.api.PhotoOperations;
import org.springframework.social.fivepx.api.PhotoResult;
import org.springframework.social.fivepx.api.PhotoSearchFilter;
import org.springframework.social.fivepx.api.PhotoSearchResult;
import org.springframework.social.fivepx.api.PhotoStream;
import org.springframework.social.fivepx.api.PhotoStreamFilter;
import org.springframework.social.fivepx.api.PhotoStreamResult;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;
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
		return getPhoto(photoId, null).getPhoto();
	}
	
	@Override
	public PhotoResult getPhoto(Long photoId, PhotoFilter filter) {
		Assert.notNull(photoId);
		MultiValueMap<String, String> params = filter == null
				? new LinkedMultiValueMap<String, String>()
				: filter.toParams();
		final URI uri = buildUri("{id}", params, urlVariables("id", photoId));
		return getRestTemplate().getForObject(uri, PhotoResult.class);
	}

	@Override
	public PhotoStreamResult getPhotos() {
		return getPhotos(PhotoStreamFilter.by(PhotoStream.FRESH_TODAY));
	}

	@Override
	public PhotoStreamResult getPhotos(PhotoStreamFilter filter) {
		Assert.notNull(filter);
		return getRestTemplate().getForObject(buildUri(filter.toParams()), PhotoStreamResult.class);
	}

	@Override
	public PhotoSearchResult search(PhotoSearchFilter filter) {
		Assert.notNull(filter);
		return getRestTemplate().getForObject(buildUri("search", filter.toParams()), PhotoSearchResult.class);
	}

	@Override
	public OperationResult addToFavorites(Long photoId) {
		requireAuthorization();
		return getRestTemplate().postForObject(buildUri("{id}/favorite", urlVariables("id", photoId)),
				null, OperationResult.class);
	}

	@Override
	public OperationResult removeFromFavorites(Long photoId) {
		requireAuthorization();
		return getRestTemplate().postForObject(
				buildUri("{id}/favorite", params("_method", "delete"), urlVariables("id", photoId)),
				null, OperationResult.class);
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
