/**
 * 
 */

package com.sapient.sku.model;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author sudhirk
 *
 */
@Converter(autoApply = true)
public class SizeConverter implements AttributeConverter<Size, String> {

	@Override
	public String convertToDatabaseColumn(Size attribute) {
		if (attribute == null)
			return null;
		return attribute.getCode();
	}

	@Override
	public Size convertToEntityAttribute(String dbData) {
		if (dbData == null)
			return null;
		return Stream.of(Size.values()).filter(size -> size.getCode().equals(dbData)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
