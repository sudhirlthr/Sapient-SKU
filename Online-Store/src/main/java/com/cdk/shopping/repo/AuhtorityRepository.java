/**
 * 
 */
package com.cdk.shopping.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdk.shopping.model.Authority;

/**
 * @author sudhirk
 *
 */
@Repository
public interface AuhtorityRepository extends JpaRepository<Authority, Long>{

}
