package com.GestionePrenotazioni.GestionePrenotazioni.config;

import com.GestionePrenotazioni.GestionePrenotazioni.model.Edificio;
import com.GestionePrenotazioni.GestionePrenotazioni.model.Postazione;
import com.GestionePrenotazioni.GestionePrenotazioni.model.Utente;
import com.GestionePrenotazioni.GestionePrenotazioni.repository.EdificioRepository;
import com.GestionePrenotazioni.GestionePrenotazioni.repository.PostazioneRepository;
import com.GestionePrenotazioni.GestionePrenotazioni.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CLR implements CommandLineRunner {

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private EdificioRepository edificioRepository;

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Override
    public void run(String... args) throws Exception {

        List<Utente> utenti = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Utente utente = new Utente("utente" + i, "utente" + i + "@example.com", "Utente " + i);
            utenti.add(utente);
        }
        utenteRepository.saveAll(utenti);

        for (int i = 1; i <= 5; i++) {
            Edificio edificio = new Edificio("Edificio " + i, "Indirizzo " + i, "Città " + i);
            edificioRepository.save(edificio);

            List<Postazione> postazioni = new ArrayList<>();
            for (int j = 1; j <= 5; j++) {
                Postazione postazione = new Postazione("Postazione " + j, "Descrizione " + j, Postazione.TipoPostazione.OPENSPACE, 1, edificio);
                postazioni.add(postazione);
            }
            postazioneRepository.saveAll(postazioni);
        }
    }
}
