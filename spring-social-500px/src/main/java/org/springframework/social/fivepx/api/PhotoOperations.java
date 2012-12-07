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

	Photo getPhoto(Long photoId, PhotoImageSize imageSize);

	PhotoResult getPhoto(Long photoId, Boolean comments, Integer commentsPage,
			Boolean tags, PhotoImageSize imageSize);

	PhotoStreamResult getPhotos();

	PhotoStreamResult getPhotos(PhotoStream stream);

	PhotoStreamResult getPhotos(UserStream stream, Long userId, String username);

	PhotoStreamResult getPhotos(PhotoStream stream, PhotoSearchResult.Sort sort, Integer page, Integer resultsToReturn,
			Boolean includeStore, Boolean includeState, Boolean tags, PhotoImageSize... imageSizes);
	
	PhotoStreamResult getPhotos(UserStream stream, Long userId, String username, PhotoSearchResult.Sort sort,
			Integer page, Integer resultsToReturn, Boolean includeStore, Boolean includeState,
			Boolean tags, PhotoImageSize... imageSizes);

	PhotoSearchResult searchByKeywords(String term);

	PhotoSearchResult searchByTag(String tag);

	OperationResult addToFavorites(Long photoId);

	OperationResult removeFromFavorites(Long photoId);

	OperationResult like(Long photoId);

	OperationResult dislike(Long photoId);

}
