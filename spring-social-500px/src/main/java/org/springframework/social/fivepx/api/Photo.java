package org.springframework.social.fivepx.api;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Photo {

//	id — ID of the photo, integer
//	name — Title of the photo, string
//	description — Description of the photo, string
//	category — Category of the photo, (short) integer
//	image_url — URL of the image, string
//	images — Array with images URL and sizes
//	rating — Rating of the photo, decimal
//	votes_count — The number of votes cast on this photo, integer
//	favorites_count — The number of users that have this photo in favorites, integer
//	comments_count — The number of comments on this photo, integer
//	times_viewed — The number of times this photo has been viewed, integer
//	created_at — Timestamp indicating time of photo creation, timestamp
//	user — Author’s profile in short format, object

	private Long id;

	private String name;

	private String description;

	private PhotoCategory category;

	private String imageUrl;

	private List<PhotoImage> images;

	private Double rating;

	private Integer votesCount;

	private Integer favoritesCount;

	private Integer commentsCount;

	private Integer timesViewed;

	private Date createdAt;

}
