package com.GestionePrenotazioni.GestionePrenotazioni.service;

import com.GestionePrenotazioni.GestionePrenotazioni.model.Postazione;
import com.GestionePrenotazioni.GestionePrenotazioni.model.Prenotazione;
import com.GestionePrenotazioni.GestionePrenotazioni.model.Utente;
import com.GestionePrenotazioni.GestionePrenotazioni.repository.PostazioneRepository;
import com.GestionePrenotazioni.GestionePrenotazioni.repository.PrenotazioneRepository;
import com.GestionePrenotazioni.GestionePrenotazioni.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Transactional
    public Prenotazione prenotaPostazione(String username, Long postazioneId, LocalDate data) throws Exception {
        Optional<Utente> utenteOptional = utenteRepository.findById(username);
        Optional<Postazione> postazioneOptional = postazioneRepository.findById(postazioneId);

        if (utenteOptional.isEmpty() || postazioneOptional.isEmpty()) {
            throw new Exception("Utente o Postazione non trovati");
        }

        Utente utente = utenteOptional.get();
        Postazione postazione = postazioneOptional.get();

        if (!prenotazioneRepository.findByUtenteAndData(utente, data).isEmpty()) {
            throw new Exception("L'utente ha già una prenotazione per questa data");
        }

        if (!prenotazioneRepository.findByPostazioneAndData(postazione, data).isEmpty()) {
            throw new Exception("La postazione è già prenotata per questa data");
        }

        Prenotazione prenotazione = new Prenotazione(null, utente, postazione, data);
        return prenotazioneRepository.save(prenotazione);
    }

    public List<Postazione> trovaPostazioni(Postazione.TipoPostazione tipo, String citta) {
        return postazioneRepository.findByTipoAndEdificio_Citta(tipo, citta);
    }
}
