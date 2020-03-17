/**
 * 
 */
package com.cdk.shopping.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdk.shopping.model.Order;

/**
 * @author sudhirk
 *
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
