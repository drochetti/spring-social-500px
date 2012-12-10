package org.springframework.social.fivepx.api;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.fivepx.api.json.Converters.ProfileGenderDeserializer;
import org.springframework.social.fivepx.api.json.Converters.ProfileStatusDeserializer;

@Data
public class FivepxProfile implements Serializable {

	private static final long serialVersionUID = 1L;

	// Short

	private Long id;

	private String username;

	private String firstname;

	private String lastname;

	private String fullname;

	private String city;

	private String country;

	@JsonProperty("upgrade_status")
	@JsonDeserialize(using = ProfileStatusDeserializer.class)
	private ProfileStatus upgradeStatus;

	// Full

	@JsonProperty("userpic_url")
	private String userpicUrl;

	private String about;

	private String domain;

	@JsonProperty("sex")
	@JsonDeserialize(using = ProfileGenderDeserializer.class)
	private ProfileGender gender;

	@JsonProperty("followers_count")
	private Integer followersCount;

	@JsonProperty("in_favourites_count")
	private Integer inFavouritesCount;

	@JsonProperty("friends_count")
	private Integer friendsCount;

	private Integer affection;

	@JsonProperty("registration_date")
	private Date registrationDate;

}
