package org.springframework.social.fivepx.api;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class FivepxProfile implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Long id;

	private final String userName;

	private final String name;

	private final String userpicUrl;

	private String about;

	private String domain;

	private String city;

	private String country;

	private String sex;

	private int followersCount;

	private int inFavouritesCount;

	private int friendsCount;

	private int affection;

	private Date registrationDate;

	public FivepxProfile(Long id, String userName, String name,	String userpicUrl) {
		super();
		this.id = id;
		this.userName = userName;
		this.name = name;
		this.userpicUrl = userpicUrl;
	}

}
