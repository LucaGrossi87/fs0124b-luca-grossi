package com.GestionePrenotazioni.GestionePrenotazioni.controller;

import com.GestionePrenotazioni.GestionePrenotazioni.model.Postazione;
import com.GestionePrenotazioni.GestionePrenotazioni.model.Prenotazione;
import com.GestionePrenotazioni.GestionePrenotazioni.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @PostMapping
    public ResponseEntity<Prenotazione> prenotaPostazione(@RequestParam String username, @RequestParam Long postazioneId, @RequestParam String data) {
        try {
            LocalDate dataPrenotazione = LocalDate.parse(data);
            Prenotazione prenotazione = prenotazioneService.prenotaPostazione(username, postazioneId, dataPrenotazione);
            return ResponseEntity.ok(prenotazione);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/postazioni")
    public ResponseEntity<List<Postazione>> trovaPostazioni(@RequestParam Postazione.TipoPostazione tipo, @RequestParam String citta) {
        List<Postazione> postazioni = prenotazioneService.trovaPostazioni(tipo, citta);
        return ResponseEntity.ok(postazioni);
    }
}
