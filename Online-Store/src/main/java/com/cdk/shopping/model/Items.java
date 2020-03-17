/**
 * 
 */
package com.cdk.shopping.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author sudhirk
 *
 */
@Entity
@Data
@Getter
@Setter
@Table(name = "items")
public class Items implements Serializable{

	
	
	public Items() {
	}

	public Items(@NotEmpty(message = "Please provide item name") String name,
			@NotEmpty(message = "Please provide item model number") String model_no,
			@NotEmpty(message = "Please provide item mrp") Double mrp,
			@NotEmpty(message = "Please provide items discount") Double discount,
			@NotEmpty(message = "Please provide items sale price") Double sale_price,
			@NotEmpty(message = "Items either should be available or not be available") Boolean available,
			@NotEmpty(message = "Items picture url required") String pictureUrl) {
		this.name = name;
		this.model_no = model_no;
		this.mrp = mrp;
		this.discount = discount;
		this.sale_price = sale_price;
		this.available = available;
		this.pictureUrl = pictureUrl;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7185084687279047865L;
	

	@Id 
	@Setter
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private Long Id;
	
	@NotEmpty(message = "Please provide item name")
	private String name;
	
	@NotEmpty(message = "Please provide item model number")
	private String model_no;
	
	//@NotEmpty(message = "Please provide item mrp")
	private Double mrp;
	
	//@NotEmpty(message = "Please provide items discount")
	private Double discount;
	
	//@NotEmpty(message = "Please provide items sale price")
	private Double sale_price;
	
	//@NotEmpty(message = "Items either should be available or not be available")
	private Boolean available;
	
	//@NotEmpty(message = "Items picture url required")
	private String pictureUrl;
	
}
