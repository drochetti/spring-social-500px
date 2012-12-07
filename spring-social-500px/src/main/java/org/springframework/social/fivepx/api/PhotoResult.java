package org.springframework.social.fivepx.api;

import java.util.List;

import lombok.Data;

@Data
public class PhotoResult {

	private Photo photo;

	private List<PhotoComment> comments;

}
