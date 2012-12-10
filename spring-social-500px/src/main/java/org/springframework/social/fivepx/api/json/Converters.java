package org.springframework.social.fivepx.api.json;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.springframework.core.GenericTypeResolver;
import org.springframework.social.fivepx.api.PhotoCategory;
import org.springframework.social.fivepx.api.PhotoImageSize;
import org.springframework.social.fivepx.api.PhotoStream;
import org.springframework.social.fivepx.api.ProfileGender;
import org.springframework.social.fivepx.api.ProfileStatus;
import org.springframework.social.fivepx.api.Stream;
import org.springframework.social.fivepx.api.UserStream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Converters {

	public static class EnumIdDeserializer<E extends Enum> extends JsonDeserializer<E> {
		@Override
		public E deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
			E match = null;
			final Integer id = jp.getValueAsInt();
			Class<E> enumType = (Class<E>) GenericTypeResolver.resolveTypeArgument(getClass(), EnumIdDeserializer.class);
			for (E enumConstant : enumType.getEnumConstants()) {
				if (id.equals(getId(enumConstant))) {
					match = enumConstant;
					break;
				}
			}
			return match;
		}

		private Integer getId(E enumConstant) {
			try {
				return (Integer) enumConstant.getClass().getMethod("getId").invoke(enumConstant);
			} catch (Exception e) {
				throw new IllegalStateException("Error invoking getId() on " + enumConstant.getClass(), e);
			}
		}

	}

	public static class PhotoImageSizeDeserializer extends EnumIdDeserializer<PhotoImageSize> {	}

	public static class PhotoCategoryDeserializer extends EnumIdDeserializer<PhotoCategory> { }

	public static class ProfileGenderDeserializer extends EnumIdDeserializer<ProfileGender> { }

	public static class ProfileStatusDeserializer extends EnumIdDeserializer<ProfileStatus> { }

	public static class StreamDeserializer extends JsonDeserializer<Stream> {

		@Override
		public Stream deserialize(JsonParser jp, DeserializationContext ctxt)
				throws IOException, JsonProcessingException {
			Set<Stream> allStreamItems = new HashSet<Stream>();
			allStreamItems.addAll(Arrays.asList(PhotoStream.values()));
			allStreamItems.addAll(Arrays.asList(UserStream.values()));
			Stream match = null;
			final String streamName = jp.getText();
			for (Stream streamItem : allStreamItems) {
				if (streamItem.getParamValue().equals(streamName)) {
					match = streamItem;
					break;
				}
			}
			return match;
		}
		
	}

}
