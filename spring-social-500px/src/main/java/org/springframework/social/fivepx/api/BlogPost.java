package org.springframework.social.fivepx.api;

import java.util.Date;
import java.util.List;
import java.util.Set;

import lombok.Data;

import org.codehaus.jackson.annotate.JsonProperty;

@Data
public class BlogPost {

	// Short format

	private Long id;

	private String title;

	@JsonProperty("created_at")
	private Date createdAt;

	private FivepxProfile user;

	// Full format

	private String body;

	private Double latitude;

	private Double longitude;

	private Set<String> tags;

	private List<Photo> photos;

}
