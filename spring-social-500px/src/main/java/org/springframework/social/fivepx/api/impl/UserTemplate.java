package org.springframework.social.fivepx.api.impl;

import org.springframework.social.fivepx.api.FivepxProfile;
import org.springframework.social.fivepx.api.UserOperations;

public class UserTemplate extends AbstractFivepxOperations implements UserOperations {

	public UserTemplate(final FivepxTemplate fivepxTemplate) {
		super(fivepxTemplate);
	}

	@Override
	public Long getProfileId() {
		requireAuthorization();
		return getUserProfile().getId();
	}

	@Override
	public String getScreenName() {
		requireAuthorization();
		return getUserProfile().getName();
	}

	@Override
	public FivepxProfile getUserProfile() {
		requireAuthorization();
		return getRestTemplate().getForObject(buildUri("users"), FivepxProfile.class);
	}

	@Override
	public FivepxProfile getUserProfileWithEmail(String email) {
		return getRestTemplate().getForObject(buildUri("show", params("email", email)), FivepxProfile.class);

	}

	@Override
	public FivepxProfile getUserProfileWithUsername(String userName) {
		return getRestTemplate().getForObject(buildUri("show", params("username", userName)), FivepxProfile.class);

	}

	@Override
	public FivepxProfile getUserProfileWithId(Long userId) {
		return getRestTemplate().getForObject(buildUri("show", params("id", userId)), FivepxProfile.class);
	}

	@Override
	protected String getEndpointPath() {
		return "users/";
	}

}
