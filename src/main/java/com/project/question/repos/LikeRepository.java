package com.project.question.repos;

import com.project.question.entities.Like;
import com.project.question.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like,Long> {
}
