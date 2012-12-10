package org.springframework.social.fivepx.api;

public enum UserStream implements Stream {

	USER,
	USER_FRIENDS,
	USER_FAVORITES;

	@Override
	public String getParamValue() {
		return name().toLowerCase();
	}

}
