/**
 * 
 */
package com.cdk.shopping.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sudhirk
 *
 */
@Entity
@Getter
@Setter
public class OrderItems {
	@EmbeddedId
    @JsonIgnore
    private OrderItemsCPk pk;

    @Column(nullable = false) private Integer quantity;

    public OrderItems() {
        super();
    }

    public OrderItems(Order order, Items items, Integer quantity) {
        pk = new OrderItemsCPk();
        pk.setOrder(order);
        pk.setItems(items);
        this.quantity = quantity;
    }

    @Transient
    public Items getItems() {
        return this.pk.getItems();
    }

    @Transient
    public Double getTotalPrice() {
        return getItems().getSale_price() * getQuantity();
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItems other = (OrderItems) obj;
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}
}
