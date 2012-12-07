package org.springframework.social.fivepx.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum PhotoImageSize {

	THUMB(1),
	SMALL(2),
	MEDIUM(3),
	LARGE(4);

	@Getter
	private final Integer id;

}
