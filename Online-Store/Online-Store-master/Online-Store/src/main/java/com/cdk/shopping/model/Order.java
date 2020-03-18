/**
 * 
 */
package com.cdk.shopping.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sudhirk
 *
 */
@Entity
@Table(name = "orders")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="orderProducts")
@Getter
@Setter
public class Order implements Cloneable{
	
	 	public Order() {
	}
		public Order(LocalDate dateCreated, @Valid List<OrderItems> orderItems) {
		this.dateCreated = dateCreated;
		this.orderItems = orderItems;
	}
		public Order(LocalDate dateCreated, String status, @Valid List<OrderItems> orderItems) {
		this.dateCreated = dateCreated;
		this.status = status;
		this.orderItems = orderItems;
	}

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @JsonFormat(pattern = "dd/MM/yyyy") private LocalDate dateCreated;

	    private String status;

	    @OneToMany(mappedBy = "pk.order")
	    @Valid
	    private List<OrderItems> orderItems = new ArrayList<>();

	    @Transient
	    public Double getTotalOrderPrice() {
	        double sum = 0D;
	        List<OrderItems> orderItems = getOrderItems();
	        for (OrderItems op : orderItems) {
	            sum += op.getTotalPrice();
	        }

	        return sum;
	    }
		@Transient
	    public int getNumberOfProducts() {
	        return this.orderItems.size();
	    }
		
		@Override
		protected Object clone() throws CloneNotSupportedException {
			Order order = null;
		    try {
		        order = (Order) super.clone();
		    } catch (CloneNotSupportedException e) {
		    	order = new Order(
		          this.getDateCreated(), this.getOrderItems());
		    }
		    return order;
		}
}
