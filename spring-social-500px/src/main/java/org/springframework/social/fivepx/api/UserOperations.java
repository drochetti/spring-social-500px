package org.springframework.social.fivepx.api;

public interface UserOperations {

	Long getProfileId();

	String getScreenName();

	FivepxProfile getUserProfile();
	
	FivepxProfile getUserProfileWithEmail(String email);

	FivepxProfile getUserProfileWithUsername(String userName);

	FivepxProfile getUserProfileWithId(Long userId);

}
