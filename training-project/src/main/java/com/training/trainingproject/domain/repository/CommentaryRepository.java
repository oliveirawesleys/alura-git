package com.training.trainingproject.domain.repository;

import com.training.trainingproject.api.model.Commentary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaryRepository extends JpaRepository<Commentary, Long> {
}
