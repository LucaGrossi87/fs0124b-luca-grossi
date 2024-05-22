package com.webapi.webapi.repository;

import com.webapi.webapi.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findById (Long id);
}
