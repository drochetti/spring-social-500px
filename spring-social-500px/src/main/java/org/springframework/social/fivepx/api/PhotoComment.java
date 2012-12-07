package org.springframework.social.fivepx.api;

import java.util.Date;

import lombok.Data;

@Data
public class PhotoComment {

	private Long id;

	private Long userId;

	private Long toWhomUserId;

	private String body;

	private Date createdAt;

	private Long parentId;

	private FivepxProfile user;

}
