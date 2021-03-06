package com.training.trainingproject.domain.repository;

import com.training.trainingproject.domain.model.OrderWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderWorkRepository extends JpaRepository<OrderWork, Long> {
}
