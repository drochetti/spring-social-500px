package org.springframework.social.fivepx.api;

import static org.springframework.social.fivepx.api.util.ApiUriUtils.params;

import java.util.Set;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Wither;

import org.springframework.social.fivepx.api.PhotoSearchResult.Sort;
import org.springframework.util.Assert;
import org.springframework.util.MultiValueMap;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PhotoStreamFilter {

	@Getter
	private final Stream stream;

	@Wither @Getter
	private final PhotoCategory only;

	@Wither @Getter
	private final PhotoCategory exclude;

	@Wither @Getter
	private final Sort sort;

	@Wither @Getter
	private final Integer page;

	@Wither @Getter
	private final Integer resultsPerPage;

	@Wither @Getter
	private final Boolean includeStore;

	@Wither @Getter
	private final Boolean includeStates;

	@Wither @Getter
	private final Boolean tags;

	@Wither @Getter
	private final Set<PhotoImageSize> imageSizes;

	@Getter
	private final String username;
	
	@Getter
	private final Long userId;

	public static PhotoStreamFilter by(PhotoStream photoStream) {
		return new PhotoStreamFilter(photoStream, null, null, null, null, null, null, null, null, null, null, null);
	}
	
	public static PhotoStreamFilter byUser(UserStream userStream, String username) {
		return new PhotoStreamFilter(userStream, null, null, null, null, null, null, null, null, null, username, null);
	}
	
	public static PhotoStreamFilter byUser(UserStream userStream, Long userId) {
		return new PhotoStreamFilter(userStream, null, null, null, null, null, null, null, null, null, null, userId);
	}

	public MultiValueMap<String, String> toParams() {
		Assert.notNull(stream);
		MultiValueMap<String, String> parameters = params(
				"feature", stream.getParamValue(),
				"only", only != null ? only.getLabel() : null,
				"exclude", exclude != null ? exclude.getLabel() : null,
				"sort", sort != null ? sort.name().toLowerCase() : null,
				"page", page,
				"rpp", resultsPerPage,
				"include_store", includeStore,
				"include_states", includeStates,
				"tags", tags);

		if (imageSizes != null) {
			String imageSizeParamName = "image_size";
			if (imageSizes.size() > 1) {
				imageSizeParamName += "[]";
			}
			for (PhotoImageSize imageSize : imageSizes) {
				parameters.add(imageSizeParamName, imageSize.getId().toString());
			}
		}

		return parameters;
	}

}
