package org.springframework.social.fivepx.api.impl.json;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.module.SimpleModule;
import org.springframework.social.fivepx.api.FivepxProfile;
import org.springframework.social.fivepx.api.Photo;

public class FivepxModule extends SimpleModule {

	public FivepxModule() {
		super("FivepxModule", new Version(1, 0, 0, null));
	}

	@Override
	public void setupModule(SetupContext context) {
		context.setMixInAnnotations(FivepxProfile.class, FivepxProfileMixin.class);
		context.setMixInAnnotations(Photo.class, PhotoMixin.class);
	}

}
