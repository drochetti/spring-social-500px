package org.springframework.social.fivepx.api;

import java.util.List;

import lombok.Data;

@Data
public class PhotoSearchResult {

	public static enum Sort {
		CREATED_AT,
		RATING,
		TIMES_VIEWED,
		VOTES_COUNT,
		FAVORITES_COUNT,
		COMMENTS_COUNT,
		TAKEN_AT;
	}

	private Stream stream;

	private Integer currentPage;

	private Integer totalPages;

	private Long totalItems;

	private List<Photo> photos;

}
