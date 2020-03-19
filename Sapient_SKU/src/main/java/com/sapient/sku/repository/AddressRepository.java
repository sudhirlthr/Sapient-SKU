/**
 * 
 */
package com.sapient.sku.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.sku.model.Address;

/**
 * @author sudhirk
 *
 */
@Repository
@Transactional
public interface AddressRepository extends JpaRepository<Address, Long>{

}
