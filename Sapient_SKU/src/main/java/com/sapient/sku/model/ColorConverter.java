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
public class ColorConverter implements AttributeConverter<Colors, String> {

	@Override
	public String convertToDatabaseColumn(Colors attribute) {
		if (attribute == null)
			return null;
		return attribute.getCode();
	}

	@Override
	public Colors convertToEntityAttribute(String dbData) {
		if (dbData == null)
			return null;
		return Stream.of(Colors.values()).filter(colors -> colors.getCode().equals(dbData)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
