package org.springframework.social.fivepx.api;

import java.util.Date;
import java.util.List;
import java.util.Set;

import lombok.Data;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.fivepx.api.json.Converters.PhotoCategoryDeserializer;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Photo {

	// Short format

	private Long id;

	private String name;

	private String description;

	@JsonDeserialize(using = PhotoCategoryDeserializer.class)
	private PhotoCategory category;

	@JsonProperty("image_url")
	private String imageUrl;

	private List<PhotoImage> images;

	private Double rating;

	@JsonProperty("votes_count")
	private Integer votesCount;

	@JsonProperty("favorites_count")
	private Integer favoritesCount;

	@JsonProperty("comments_count")
	private Integer commentsCount;

	@JsonProperty("times_viewed")
	private Integer timesViewed;

	@JsonProperty("created_at")
	private Date createdAt;
	
	private Integer width;
	
	private Integer height;

	private Boolean nsfw;

	@JsonProperty("user_id")
	private Long userId;

	private FivepxProfile user;

	// Full format

	@JsonProperty("for_sale")
	private Boolean forSale;

	@JsonProperty("sales_count")
	private Integer salesCount;

	private String camera;

	private String lens;

	private String apperture;

	private String iso;

	@JsonProperty("shutter_speed")
	private String shutterSpeed;

	@JsonProperty("taken_at")
	private String takenAt;

	private String location;

	private Double latitude;

	private Double longitude;

	// Values returned on "tags"
	private Set<String> tags;

	// Values returned on "include_store"

	@JsonProperty("store_download")
	private Boolean storeDownload;

	@JsonProperty("store_print")
	private Boolean storePrint;

	// Values returned on "include_states" and authenticated request

	private Boolean voted;

	private Boolean favorited;
	
	private Boolean purchased;

}
