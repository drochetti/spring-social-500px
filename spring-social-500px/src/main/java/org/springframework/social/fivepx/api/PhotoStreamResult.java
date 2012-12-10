package org.springframework.social.fivepx.api;

import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.fivepx.api.json.Converters.PhotoCategoryDeserializer;
import org.springframework.social.fivepx.api.json.Converters.StreamDeserializer;

@Data
@EqualsAndHashCode(callSuper = true)
public class PhotoStreamResult extends PhotoSearchResult {

	@JsonDeserialize(using = StreamDeserializer.class)
	@JsonProperty("feature")
	private Stream stream;

	private UsedFilters filters;

	@Data
	public static class UsedFilters {

		@JsonDeserialize(using = PhotoCategoryDeserializer.class)
		private PhotoCategory category;

		@JsonDeserialize(using = PhotoCategoryDeserializer.class)
		private PhotoCategory exclude;

		@JsonProperty("user_id")
		private Long userId;

		@JsonProperty("friends_ids")
		private Set<Long> friendsIds;

	}

}
