package com.GestionePrenotazioni.GestionePrenotazioni.repository;

import com.GestionePrenotazioni.GestionePrenotazioni.model.Postazione;
import com.GestionePrenotazioni.GestionePrenotazioni.model.Prenotazione;
import com.GestionePrenotazioni.GestionePrenotazioni.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    List<Prenotazione> findByUtenteAndData(Utente utente, LocalDate data);
    List<Prenotazione> findByPostazioneAndData(Postazione postazione, LocalDate data);
}
