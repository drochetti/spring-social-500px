package org.springframework.social.fivepx.api.impl;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.fivepx.api.util.ApiUriUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class AbstractFivepxOperations {

	protected final FivepxTemplate fivepxTemplate;

	public AbstractFivepxOperations(final FivepxTemplate fivepxTemplate) {
		this.fivepxTemplate = fivepxTemplate;
	}

	protected void requireAuthorization() {
		if (!fivepxTemplate.isAuthorized()) {
			throw new MissingAuthorizationException();
		}
	}
	
	protected URI buildUri() {
		return buildUri("", EMPTY_PARAMETERS, EMPTY_URI_VARIABLES);
	}
	
	protected URI buildUri(MultiValueMap<String, String> parameters) {
		return buildUri("", parameters, EMPTY_URI_VARIABLES);
	}

	protected URI buildUri(String path) {
		return buildUri(path, EMPTY_PARAMETERS, EMPTY_URI_VARIABLES);
	}

	protected URI buildUri(String path, MultiValueMap<String, String> parameters) {
		return buildUri(path, parameters, EMPTY_URI_VARIABLES);
	}

	protected URI buildUri(String path, Map<String, String> uriVariables) {
		return buildUri(path, EMPTY_PARAMETERS, uriVariables);
	}

	protected URI buildUri(String path, MultiValueMap<String, String> parameters, Map<String, String> uriVariables) {
		UriComponentsBuilder uriBuilder = fivepxTemplate.uriBuilder(getEndpointPath() + path);
		for (String paramName : parameters.keySet()) {
			uriBuilder.queryParam(paramName, parameters.get(paramName).toArray());
		}
		return uriBuilder.build().expand(uriVariables).toUri();
	}

	/**
	 * 
	 * @param keysAndValues
	 * @return
	 */
	protected MultiValueMap<String, String> params(Object... keysAndValues)  {
		return ApiUriUtils.params(keysAndValues);
	}

	protected Map<String, String> urlVariables(Object... keysAndValues) {
		return ApiUriUtils.urlVariables(keysAndValues);
	}

	protected String getEndpointPath() {
		return "";
	}

	public RestTemplate getRestTemplate() {
		return fivepxTemplate.getRestTemplate();
	}

	private static final LinkedMultiValueMap<String, String> EMPTY_PARAMETERS = new LinkedMultiValueMap<String, String>();

	private static final Map<String, String> EMPTY_URI_VARIABLES = new HashMap<String, String>();

}
