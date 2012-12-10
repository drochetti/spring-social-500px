package org.springframework.social.fivepx.api;

import lombok.Data;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.fivepx.api.json.Converters.PhotoImageSizeDeserializer;

@Data
public class PhotoImage {

	@JsonDeserialize(using = PhotoImageSizeDeserializer.class)
	private PhotoImageSize size;

	private String url;

}
