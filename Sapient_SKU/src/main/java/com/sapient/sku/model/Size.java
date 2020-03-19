/**
 * 
 */
package com.sapient.sku.model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author sudhirk
 *
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Size {
	SMALL("S"), MEDIUM("M"), LARGE("L"), 
	@JsonEnumDefaultValue
	EXTRALARGE("XL");
	private String code;

	private Size(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
