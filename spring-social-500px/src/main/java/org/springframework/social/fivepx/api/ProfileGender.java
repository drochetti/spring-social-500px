package org.springframework.social.fivepx.api;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ProfileGender {

	MALE(1),
	FEMALE(2);

	@Getter
	private final Integer id;

}
