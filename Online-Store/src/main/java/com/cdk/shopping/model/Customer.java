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
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

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
public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
	@Setter
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "custid")
	private Long id;
	
	@NotEmpty(message = "Please provide your first name")
	@Column(name = "first_name")
	private String FirstName;
	
	@Column(name = "last_name")
	@NotEmpty(message = "Please provide your first name")
	private String LastName;
	
	@Column(name = "email", nullable = false, unique = true)
	@Email(message = "Please provide a valid e-mail")
	@NotEmpty(message = "Please provide an e-mail")
	private String email;
	
	@Column(name = "customer_type", nullable = false)
	//@NotEmpty(message = "Please provide customer_type")
	private String customer_type;
	
	
	//private Address address;
	
	@Column(name = "password")
	//@Transient
	private String password;	
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@Column(name = "confirmation_token")
	private String confirmationToken;
}
