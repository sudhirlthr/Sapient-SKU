/**
 * 
 */
package com.cdk.shopping.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdk.shopping.model.Items;

/**
 * @author sudhirk
 *
 */
@Repository
public interface ItemRepository extends JpaRepository<Items, Long>{
	
}
