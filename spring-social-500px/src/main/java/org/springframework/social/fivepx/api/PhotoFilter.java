package org.springframework.social.fivepx.api;

import static org.springframework.social.fivepx.api.util.ApiUriUtils.params;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Wither;

import org.springframework.util.MultiValueMap;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PhotoFilter {
	
	@Wither @Getter
	private final Boolean comments;
	
	@Wither @Getter
	private final Integer commentsPage;

	@Wither @Getter
	private final Boolean tags;

	@Wither @Getter
	private final PhotoImageSize imageSize;

	public static PhotoFilter loadTags() {
		return new PhotoFilter(null, null, true, null);
	}

	public static PhotoFilter loadComments() {
		return new PhotoFilter(true, null, null, null);
	}

	public static PhotoFilter loadComments(Integer page) {
		return new PhotoFilter(true, page, null, null);
	}

	public MultiValueMap<String, String> toParams() {
		return params(
				"comments", comments.toString(),
				"comments_page", commentsPage.toString(),
				"tags", tags.toString(),
				"image_size", imageSize != null ? imageSize.getId().toString() : null);
	}

}
