/**
 * 
 */
package com.sapient.sku.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
@Setter
@Getter
@NoArgsConstructor
public class Address {

	@Id
	@Setter
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long address_id;
	
	//@NotEmpty(message = "Please provide house number")
	private String housenumber;
	//@NotEmpty(message = "Please provide pincode")
	private String street;
	//@NotEmpty(message = "Please provide pincode")
	private Integer pincode;
	//@NotEmpty(message = "Please provide state")
	private String state;
	//@NotEmpty(message = "Please provide country")
	private String country;
	
	@JsonManagedReference
	@ManyToOne(fetch = FetchType.LAZY)
	private Seller seller;
	public Address(Long address_id, @NotEmpty(message = "Please provide house number") String housenumber,
			@NotEmpty(message = "Please provide pincode") String street,
			@NotEmpty(message = "Please provide pincode") Integer pincode,
			@NotEmpty(message = "Please provide state") String state,
			@NotEmpty(message = "Please provide country") String country) {
		this.address_id = address_id;
		this.housenumber = housenumber;
		this.street = street;
		this.pincode = pincode;
		this.state = state;
		this.country = country;
	}
	public Address(String housenumber, String street, Integer pincode, String state, String country, Seller seller) {
		this.housenumber = housenumber;
		this.street = street;
		this.pincode = pincode;
		this.state = state;
		this.country = country;
		this.seller = seller;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (address_id == null) {
			if (other.address_id != null)
				return false;
		} else if (!address_id.equals(other.address_id))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (housenumber == null) {
			if (other.housenumber != null)
				return false;
		} else if (!housenumber.equals(other.housenumber))
			return false;
		if (pincode == null) {
			if (other.pincode != null)
				return false;
		} else if (!pincode.equals(other.pincode))
			return false;
		if (seller == null) {
			if (other.seller != null)
				return false;
		} else if (!seller.equals(other.seller))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address_id == null) ? 0 : address_id.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((housenumber == null) ? 0 : housenumber.hashCode());
		result = prime * result + ((pincode == null) ? 0 : pincode.hashCode());
		result = prime * result + ((seller == null) ? 0 : seller.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		return result;
	}
	
}
