package com.cdk.shopping.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdk.shopping.model.OrderItems;
import com.cdk.shopping.model.OrderItemsCPk;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItems, OrderItemsCPk>{

}
