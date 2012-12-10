package org.springframework.social.fivepx.api.impl;

import lombok.Getter;
import lombok.experimental.Accessors;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.social.fivepx.api.BlogOperations;
import org.springframework.social.fivepx.api.CollectionOperations;
import org.springframework.social.fivepx.api.Fivepx;
import org.springframework.social.fivepx.api.PhotoOperations;
import org.springframework.social.fivepx.api.UploadOperations;
import org.springframework.social.fivepx.api.UserOperations;
import org.springframework.social.fivepx.api.json.FivepxModule;
import org.springframework.social.oauth1.AbstractOAuth1ApiBinding;
import org.springframework.web.util.UriComponentsBuilder;

public class FivepxTemplate extends AbstractOAuth1ApiBinding implements Fivepx {

	private static final String API_URL_BASE = "https://api.500px.com/v1/";

	@Getter
	private final String consumerKey;

	@Getter
	@Accessors(fluent = true)
	private BlogOperations blogOperations;

	@Getter
	@Accessors(fluent = true)
	private CollectionOperations collectionOperations;

	@Getter
	@Accessors(fluent = true)
	private PhotoOperations photoOperations;

	@Getter
	@Accessors(fluent = true)
	private UploadOperations uploadOperations;

	@Getter
	@Accessors(fluent = true)
	private UserOperations userOperations;

	public FivepxTemplate(String consumerKey, String consumerSecret,
			String accessToken, String accessTokenSecret) {
		super(consumerKey, consumerSecret, accessToken, accessTokenSecret);
		this.consumerKey = consumerKey;
		init();
	}

	public FivepxTemplate(String consumerKey) {
		super();
		this.consumerKey = consumerKey;
		init();
	}

	private void init() {
		initEndpoints();
	}

	private void initEndpoints() {
		this.userOperations = new UserTemplate(this);
		this.photoOperations = new PhotoTemplate(this);
	}

	@Override
	protected MappingJacksonHttpMessageConverter getJsonMessageConverter() {
		MappingJacksonHttpMessageConverter converter = super.getJsonMessageConverter();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new FivepxModule());
		converter.setObjectMapper(objectMapper);
		return converter;
	}

	/**
	 * @param path
	 * @return
	 */
	protected UriComponentsBuilder uriBuilder(String path) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(API_URL_BASE + path);
		if (!isAuthorized()) {
			builder.queryParam("consumer_key", getConsumerKey());
		}
		return builder;
	}

}
