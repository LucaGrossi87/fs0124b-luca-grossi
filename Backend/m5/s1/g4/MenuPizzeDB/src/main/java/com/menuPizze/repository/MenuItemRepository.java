package com.menuPizze.repository;

import com.menuPizze.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findByGusto(String gusto);
}
