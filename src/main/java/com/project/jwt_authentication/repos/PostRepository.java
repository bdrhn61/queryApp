package com.project.jwt_authentication.repos;

import com.project.jwt_authentication.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {

}
