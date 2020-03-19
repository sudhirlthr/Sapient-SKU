/**
 * 
 */
package com.sapient.sku.model;

import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Setter
@Getter
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private Long product_id;
	
	private String name;
	
    @JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "brand_id", nullable = false)
	private Brand brand;
	
	private Double price;
	
	private Category category;
	
	
	//issue with JSON serialization & deserialization
	/*
	 * 
	 * @ElementCollection(targetClass=Colors.class)
	 * 
	 * @Enumerated(EnumType.STRING)
	 * 
	 * @CollectionTable(name="person")
	 * 
	 * @Column(name="product_id") private Collection<Colors> color;
	 */
	  
	 
	
	//private Integer size;
	
	//issue with JSON serialization & deserialization

	
	  //@OneToMany(cascade = CascadeType.ALL)
	  @ElementCollection(targetClass=Size.class)
	  @Enumerated(EnumType.STRING)
	  @CollectionTable(name="person")
	  @Column(name="product_id") private Collection<Size> size;
	  
	 
	
	private String color;
	
	/*
	 * @OneToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "product", joinColumns = @JoinColumn(referencedColumnName =
	 * "product_id"), inverseJoinColumns = @JoinColumn(name = "seller_id"))
	 */
    @JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "seller_id", nullable = false)
    private Seller seller;

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (category != other.category)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (product_id == null) {
			if (other.product_id != null)
				return false;
		} else if (!product_id.equals(other.product_id))
			return false;
		if (seller == null) {
			if (other.seller != null)
				return false;
		} else if (!seller.equals(other.seller))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((product_id == null) ? 0 : product_id.hashCode());
		result = prime * result + ((seller == null) ? 0 : seller.hashCode());
		return result;
	}

	public Product(Long product_id, String name, Brand brand, Double price, Category category, Collection<Size> size,
			String color, Seller seller) {
		this.product_id = product_id;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.category = category;
		this.size = size;
		this.color = color;
		this.seller = seller;
	}

	public Product(String name, Brand brand, Double price, Category category, Collection<Size> size, String color,
			Seller seller) {
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.category = category;
		this.size = size;
		this.color = color;
		this.seller = seller;
	}

	

	

	
	/*
	 * public Product(Brand brand, Double price, Set<Colors> color, Collection<Size>
	 * size, Category category, Seller seller) { this.brand = brand; this.price =
	 * price; this.color = color; this.size = size; this.category = category;
	 * this.seller = seller; }
	 * 
	 * public Product(Long product_id, Brand brand, Double price, Set<Colors> color,
	 * Collection<Size> size, Category category, Seller seller) { this.product_id =
	 * product_id; this.brand = brand; this.price = price; this.color = color;
	 * this.size = size; this.category = category; this.seller = seller; }
	 */
	
}
