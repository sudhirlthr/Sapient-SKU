/**
 * 
 */
package com.cdk.shopping.dto;

import com.cdk.shopping.model.Items;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sudhirk
 *
 */
@Getter
@Setter
public class OrderItemDTO {
	private Items items;
    private Integer quantity;
}
