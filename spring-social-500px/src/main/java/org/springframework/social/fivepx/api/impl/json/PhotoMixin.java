package org.springframework.social.fivepx.api.impl.json;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.fivepx.api.PhotoImage;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class PhotoMixin {

	@JsonCreator
	PhotoMixin(@JsonProperty("id") Long id, @JsonProperty("name") String name,
			@JsonProperty("description") String description, @JsonProperty("image_url") String imageUrl,
			List<PhotoImage> images, @JsonProperty("rating") Double rating,
			@JsonProperty("votes_count") Integer votesCount, @JsonProperty("favorites_count") Integer favoritesCount,
			@JsonProperty("comments_count") Integer commentsCount, @JsonProperty("times_viewed") Integer timesViewed,
			@JsonProperty("created_at") Date createdAt) { }

}