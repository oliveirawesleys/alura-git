package com.learning.spring.orders.domain.repository;

import com.learning.spring.orders.domain.model.OrderService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderServiceRepository extends JpaRepository<OrderService, Long> {
}
