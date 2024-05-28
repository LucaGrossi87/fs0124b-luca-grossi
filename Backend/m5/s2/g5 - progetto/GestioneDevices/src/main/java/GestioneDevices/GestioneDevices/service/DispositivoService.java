package GestioneDevices.GestioneDevices.service;

import GestioneDevices.GestioneDevices.exception.ResourceNotFoundException;
import GestioneDevices.GestioneDevices.model.Dipendente;
import GestioneDevices.GestioneDevices.model.Dispositivo;
import GestioneDevices.GestioneDevices.model.DispositivoStatus;
import GestioneDevices.GestioneDevices.repository.DispositivoRepository;
import GestioneDevices.GestioneDevices.repository.DipendenteRepository; // Import necessario
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DispositivoService {

    @Autowired
    private DispositivoRepository dispositivoRepository;

    @Autowired
    private DipendenteRepository dipendenteRepository;

    public List<Dispositivo> getAllDispositivi() {
        return dispositivoRepository.findAll();
    }

    public Optional<Dispositivo> getDispositivoById(Long id) {
        return dispositivoRepository.findById(id);
    }

    public Dispositivo saveDispositivo(Dispositivo dispositivo) {
        return dispositivoRepository.save(dispositivo);
    }

    public Optional<Dispositivo> updateDispositivo(Long id, Dispositivo dispositivo) {
        if (!dispositivoRepository.existsById(id)) {
            return Optional.empty();
        }
        dispositivo.setId(id);
        return Optional.of(dispositivoRepository.save(dispositivo));
    }

    public void deleteDispositivo(Long id) {
        dispositivoRepository.deleteById(id);
    }

    public void assignToDipendente(Long dispositivoId, Long dipendenteId) {
        Dispositivo dispositivo = dispositivoRepository.findById(dispositivoId)
                .orElseThrow(() -> new ResourceNotFoundException("Dispositivo not found with id " + dispositivoId));
        Dipendente dipendente = dipendenteRepository.findById(dipendenteId)
                .orElseThrow(() -> new ResourceNotFoundException("Dipendente not found with id " + dipendenteId));

        if (dispositivo.getStatus() == DispositivoStatus.DISPONIBILE) {
            dispositivo.setDipendente(dipendente);
            dispositivo.setStatus(DispositivoStatus.ASSEGNATO);
            dispositivoRepository.save(dispositivo);
        } else {
            throw new IllegalStateException("Dispositivo non disponibile per l'assegnazione");
        }
    }
}
