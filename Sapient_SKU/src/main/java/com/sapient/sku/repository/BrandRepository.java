/**
 * 
 */
package com.sapient.sku.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.sku.model.Brand;

/**
 * @author sudhirk
 *
 */
@Repository
@Transactional
public interface BrandRepository extends JpaRepository<Brand, Long>{

}
