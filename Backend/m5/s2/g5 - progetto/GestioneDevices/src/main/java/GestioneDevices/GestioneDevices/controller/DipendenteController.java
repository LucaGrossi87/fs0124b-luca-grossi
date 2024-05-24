package GestioneDevices.GestioneDevices.controller;

import GestioneDevices.GestioneDevices.model.Dipendente;
import GestioneDevices.GestioneDevices.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/dipendenti")
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    @GetMapping
    public List<Dipendente> getAllDipendenti() {
        return dipendenteService.getAllDipendenti();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dipendente> getDipendenteById(@PathVariable Long id) {
        return ResponseEntity.of(dipendenteService.getDipendenteById(id));
    }

    @PostMapping
    public ResponseEntity<Dipendente> createDipendente(@RequestBody Dipendente dipendente) {
        return new ResponseEntity<>(dipendenteService.saveDipendente(dipendente), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dipendente> updateDipendente(@PathVariable Long id, @RequestBody Dipendente dipendente) {
        return ResponseEntity.of(dipendenteService.updateDipendente(id, dipendente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDipendente(@PathVariable Long id) {
        dipendenteService.deleteDipendente(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/uploadProfileImage")
    public ResponseEntity<String> uploadProfileImage(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        String imageUrl = dipendenteService.uploadProfileImage(id, file);
        return new ResponseEntity<>(imageUrl, HttpStatus.OK);
    }
}
