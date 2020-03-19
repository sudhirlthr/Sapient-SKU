/**
 * 
 */
package com.sapient.sku.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Brand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long brand_id;
	
	@NotNull(message = "Brand should be named")
	private String name;
	
	@JsonBackReference
	@OneToMany(mappedBy = "brand")
	private Set<Product> products;
	
	public Brand(@NotNull(message = "Brand should be named") String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Brand other = (Brand) obj;
		if (brand_id == null) {
			if (other.brand_id != null)
				return false;
		} else if (!brand_id.equals(other.brand_id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand_id == null) ? 0 : brand_id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	
	
}
