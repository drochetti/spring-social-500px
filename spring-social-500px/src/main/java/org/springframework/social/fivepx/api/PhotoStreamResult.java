package org.springframework.social.fivepx.api;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PhotoStreamResult extends PhotoSearchResult {

	private Stream stream;

}
