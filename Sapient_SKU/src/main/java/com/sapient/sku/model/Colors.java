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
public enum Colors {
	
	WHITE("W"), PINK("P"), BLACK("B"), YELLOW("Y"),GREEN("G"), 
	@JsonEnumDefaultValue
	MAGENTA("M");
	
	private String code;

	private Colors(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
