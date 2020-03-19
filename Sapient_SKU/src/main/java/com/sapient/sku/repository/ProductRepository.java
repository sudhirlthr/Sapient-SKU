/**
 * 
 */
package com.sapient.sku.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.sku.model.Brand;
import com.sapient.sku.model.Product;

/**
 * @author sudhirk
 *
 */
@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByBrand(Brand brand);
	
}
