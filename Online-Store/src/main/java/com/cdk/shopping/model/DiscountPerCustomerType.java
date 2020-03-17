/**
 * 
 */
package com.cdk.shopping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author sudhirk
 *
 */
@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
@Table(name = "discount")
public class DiscountPerCustomerType {
	
	@Id 
	@Setter
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "discount_id")
	private Long id;
	
	public DiscountPerCustomerType(Integer lower, Integer higher, Integer discount, String customer_type) {
		this.lower = lower;
		this.higher = higher;
		this.discount = discount;
		this.customer_type = customer_type;
	}
	private Integer lower;
	private Integer higher;
	private Integer discount;
	private String customer_type;
	
}
