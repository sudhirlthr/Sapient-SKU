/**
 * 
 */
package com.cdk.shopping.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdk.shopping.model.DiscountPerCustomerType;

/**
 * @author sudhirk
 *
 */
@Repository
public interface DiscountRepository extends JpaRepository<DiscountPerCustomerType, Long>{

}
