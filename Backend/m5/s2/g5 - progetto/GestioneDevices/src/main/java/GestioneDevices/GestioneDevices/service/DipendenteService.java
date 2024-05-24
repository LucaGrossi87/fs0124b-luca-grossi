package GestioneDevices.GestioneDevices.service;

import GestioneDevices.GestioneDevices.exception.ResourceNotFoundException;
import GestioneDevices.GestioneDevices.model.Dipendente;
import GestioneDevices.GestioneDevices.repository.DipendenteRepository;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private Cloudinary cloudinary;

    public List<Dipendente> getAllDipendenti() {
        return dipendenteRepository.findAll();
    }

    public Optional<Dipendente> getDipendenteById(Long id) {
        return dipendenteRepository.findById(id);
    }

    public Dipendente saveDipendente(Dipendente dipendente) {
        return dipendenteRepository.save(dipendente);
    }

    public Optional<Dipendente> updateDipendente(Long id, Dipendente dipendente) {
        if (!dipendenteRepository.existsById(id)) {
            return Optional.empty();
        }
        dipendente.setId(id);
        return Optional.of(dipendenteRepository.save(dipendente));
    }

    public void deleteDipendente(Long id) {
        dipendenteRepository.deleteById(id);
    }

    public String uploadProfileImage(Long id, MultipartFile file) {
        Dipendente dipendente = dipendenteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dipendente not found with id " + id));
        try {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            String imageUrl = uploadResult.get("url").toString();
            dipendente.setImageUrl(imageUrl);
            dipendenteRepository.save(dipendente);
            return imageUrl;
        } catch (IOException e) {
            throw new RuntimeException("Image upload failed", e);
        }
    }
}
