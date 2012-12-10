package org.springframework.social.fivepx.api;

import java.util.HashSet;
import java.util.Set;

import org.springframework.util.Assert;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum PhotoImageSize {

	THUMB(1),
	SMALL(2),
	MEDIUM(3),
	LARGE(4);

	@Getter
	private final Integer id;

	public Set<PhotoImageSize> collection(PhotoImageSize... imageSizes) {
		Assert.notNull(imageSizes);
		Set<PhotoImageSize> col = new HashSet<PhotoImageSize>();
		for (PhotoImageSize imageSize : imageSizes) {
			col.add(imageSize);
		}
		return col;
	}

}
