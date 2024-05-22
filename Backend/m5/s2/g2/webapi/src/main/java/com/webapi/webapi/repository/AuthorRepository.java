package com.webapi.webapi.repository;

import com.webapi.webapi.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findAuthorById(Long id);
}
