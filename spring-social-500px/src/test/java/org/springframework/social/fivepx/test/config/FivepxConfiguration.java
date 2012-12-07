package org.springframework.social.fivepx.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.fivepx.api.Fivepx;
import org.springframework.social.fivepx.api.impl.FivepxTemplate;

@Configuration
public class FivepxConfiguration {

	private String consumerKey = "EsGxJ9QjIyaps3Y8eHErf90H2CU4l7mhZrMuEzto";

	@Bean
	public Fivepx createApi() {
		return new FivepxTemplate(consumerKey);
	}

}
