package org.springframework.social.fivepx.api;

import static org.springframework.social.fivepx.api.util.ApiUriUtils.params;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Wither;

import org.springframework.util.Assert;
import org.springframework.util.MultiValueMap;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PhotoSearchFilter {

	@Getter
	private final String term;

	@Getter
	private final String tag;

	@Wither @Getter
	private final Integer page;

	@Wither @Getter
	private final Integer resultsPerPage;

	@Wither @Getter
	private final Boolean tags;

	@Wither @Getter
	private final PhotoImageSize imageSize;

	public static PhotoSearchFilter byTag(String tag) {
		Assert.hasText(tag);
		return new PhotoSearchFilter(null, tag, null, null, true, null);
	}

	public static PhotoSearchFilter byKeywords(String term) {
		Assert.hasText(term);
		return new PhotoSearchFilter(term, null, null, null, null, null);
	}

	public MultiValueMap<String, String> toParams() {
		return params(
				"term", term,
				"tag", tag,
				"page", page,
				"rpp", resultsPerPage,
				"tags", tags,
				"image_size", imageSize != null ? imageSize.getId() : null);
	}

}
