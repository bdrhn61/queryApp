package com.project.question.repos;

import com.project.question.entities.Post;
import com.project.question.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {

}
