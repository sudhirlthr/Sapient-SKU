/**
 * 
 */
package com.sapient.sku.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Getter
@Setter
@NoArgsConstructor
public class Seller {

	@Id
	@Setter
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long seller_id;
	
	//@NotEmpty(message = "Please provide seller's name")
	private String name;
	//@NotEmpty(message = "Please provide seller's email")
	private String email;
	
	@JsonBackReference
	@OneToMany(mappedBy = "seller" ,cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Address> address = new HashSet<>();
	
    @JsonBackReference
	@OneToMany(mappedBy = "seller", targetEntity = Product.class)
	private Set<Product> products;

	public Seller(String name, String email, Set<Address> address, Set<Product> products) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.products = products;
	}





	public Seller(Long seller_id, String name, String email, Set<Address> address, Set<Product> products) {
		this.seller_id = seller_id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.products = products;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seller other = (Seller) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (seller_id == null) {
			if (other.seller_id != null)
				return false;
		} else if (!seller_id.equals(other.seller_id))
			return false;
		return true;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((seller_id == null) ? 0 : seller_id.hashCode());
		return result;
	}

	
	
	/*
	 * @ManyToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "seller", joinColumns = @JoinColumn(referencedColumnName =
	 * "seller_id"), inverseJoinColumns = @JoinColumn(name = "product_id")) private
	 * Set<Seller> seller = new HashSet<>();
	 */
}
