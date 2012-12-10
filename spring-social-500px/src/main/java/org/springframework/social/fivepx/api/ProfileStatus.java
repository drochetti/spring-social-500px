package org.springframework.social.fivepx.api;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ProfileStatus {

	NORMAL(0),
	PLUS(1),
	AWESOME(2);

	@Getter
	private final Integer id;

}
