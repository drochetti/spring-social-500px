package org.springframework.social.fivepx.api.impl;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.social.MissingAuthorizationException;
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
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (keysAndValues == null || keysAndValues.length % 2 != 0) {
			throw new IllegalArgumentException(
					"The parameters must come in pairs (key/value), hence the length cannot be an odd number.");
		}
		for (int i = 0; i < keysAndValues.length; i = i + 2) {
			Object value = keysAndValues[i + 1];
			if (value != null) {
				parameters.add(keysAndValues[i].toString(), value.toString());
			}
		}
		return parameters;
	}

	protected Map<String, String> urlVariables(Object... keysAndValues) {
		return this.params(keysAndValues).toSingleValueMap();
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
