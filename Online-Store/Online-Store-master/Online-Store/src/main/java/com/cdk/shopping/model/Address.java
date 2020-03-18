/**
 * 
 */
package com.cdk.shopping.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
public class Address implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private @Id @Setter Long id;
	private String houseNumber;
	public Address(String houseNumber, String locality, String city, Integer pincode) {
		this.houseNumber = houseNumber;
		this.locality = locality;
		this.city = city;
		this.pincode = pincode;
	}
	private String locality;
	private String city;
	private Integer pincode;
	
}
