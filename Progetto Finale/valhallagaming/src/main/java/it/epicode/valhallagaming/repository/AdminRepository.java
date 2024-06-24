package it.epicode.valhallagaming.repository;

import it.epicode.valhallagaming.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findByLoggedin (boolean loggedin);

    Optional<Admin> findByUserName (String username);
}
