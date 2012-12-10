package org.springframework.social.fivepx.api;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

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

	@JsonProperty("current_page")
	private Integer currentPage;

	@JsonProperty("total_pages")
	private Integer totalPages;

	@JsonProperty("total_items")
	private Long totalItems;

	private List<Photo> photos;

}
