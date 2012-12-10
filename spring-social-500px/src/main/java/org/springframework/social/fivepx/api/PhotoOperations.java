package org.springframework.social.fivepx.api;


/**
 * {@link Photo} endpoint operations.
 * See <a href="https://github.com/500px/api-documentation/tree/master/endpoints/photo">official docs</a>. 
 * 
 * @author Daniel Rochetti
 */
public interface PhotoOperations {

	/**
	 * Returns detailed information of a single photo.
	 * 
	 * @param photoId The Photo id
	 * @return The photo information
	 */
	Photo getPhoto(Long photoId);

	/**
	 * 
	 * @param photoId
	 * @param filter
	 * @return
	 */
	PhotoResult getPhoto(Long photoId, PhotoFilter filter);

	/**
	 * @see #getPhotos(PhotoStreamFilter)
	 * @return
	 */
	PhotoStreamResult getPhotos();

	/**
	 * 
	 * @param filter
	 * @return
	 */
	PhotoStreamResult getPhotos(PhotoStreamFilter filter);

	/**
	 * 
	 * @param filter
	 * @return
	 */
	PhotoSearchResult search(PhotoSearchFilter filter);

	OperationResult addToFavorites(Long photoId);

	OperationResult removeFromFavorites(Long photoId);

	OperationResult like(Long photoId);

	OperationResult dislike(Long photoId);

}
