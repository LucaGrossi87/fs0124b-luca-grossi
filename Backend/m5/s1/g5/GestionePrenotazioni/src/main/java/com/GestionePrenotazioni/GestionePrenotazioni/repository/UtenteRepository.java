package com.GestionePrenotazioni.GestionePrenotazioni.repository;


import com.GestionePrenotazioni.GestionePrenotazioni.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, String> {
}
