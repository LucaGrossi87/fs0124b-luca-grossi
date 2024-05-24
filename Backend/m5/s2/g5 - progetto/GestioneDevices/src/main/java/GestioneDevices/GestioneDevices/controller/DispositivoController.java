package GestioneDevices.GestioneDevices.controller;

import GestioneDevices.GestioneDevices.model.Dispositivo;
import GestioneDevices.GestioneDevices.service.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dispositivi")
public class DispositivoController {

    @Autowired
    private DispositivoService dispositivoService;

    @GetMapping
    public List<Dispositivo> getAllDispositivi() {
        return dispositivoService.getAllDispositivi();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dispositivo> getDispositivoById(@PathVariable Long id) {
        return ResponseEntity.of(dispositivoService.getDispositivoById(id));
    }

    @PostMapping
    public ResponseEntity<Dispositivo> createDispositivo(@RequestBody Dispositivo dispositivo) {
        return new ResponseEntity<>(dispositivoService.saveDispositivo(dispositivo), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dispositivo> updateDispositivo(@PathVariable Long id, @RequestBody Dispositivo dispositivo) {
        return ResponseEntity.of(dispositivoService.updateDispositivo(id, dispositivo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDispositivo(@PathVariable Long id) {
        dispositivoService.deleteDispositivo(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{dispositivoId}/assignToDipendente/{dipendenteId}")
    public ResponseEntity<Void> assignDispositivoToDipendente(@PathVariable Long dispositivoId, @PathVariable Long dipendenteId) {
        dispositivoService.assignToDipendente(dispositivoId, dipendenteId);
        return ResponseEntity.ok().build();
    }
}
