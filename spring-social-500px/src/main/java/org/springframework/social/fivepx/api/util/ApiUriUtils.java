package org.springframework.social.fivepx.api.util;

import java.util.Map;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiUriUtils {

	/**
	 * 
	 * @param keysAndValues
	 * @return
	 */
	public static MultiValueMap<String, String> params(Object... keysAndValues)  {
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

	public static Map<String, String> urlVariables(Object... keysAndValues) {
		return params(keysAndValues).toSingleValueMap();
	}

}
