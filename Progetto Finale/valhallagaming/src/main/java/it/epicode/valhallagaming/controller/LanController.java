package it.epicode.valhallagaming.controller;

import it.epicode.valhallagaming.dto.lanDTO.LanCreateRequest;
import it.epicode.valhallagaming.dto.lanDTO.LanDeleteResponse;
import it.epicode.valhallagaming.dto.lanDTO.LanEditRequest;
import it.epicode.valhallagaming.dto.lanDTO.LanResponse;
import it.epicode.valhallagaming.entity.Lan;
import it.epicode.valhallagaming.service.LanService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/lans")
public class LanController {

    @Autowired
    private LanService lanService;

    @GetMapping
    public List<LanResponse> getAllLans() {
        return lanService.findAll().stream()
                .map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping ("/{id}")
    public LanResponse getLanById(@PathVariable Long id){
        Optional<Lan> lan = lanService.findById(id);
        return lan.map(this::convertToDTO).orElse(null);
    }

    @PostMapping
    public LanResponse createLan (@RequestBody LanCreateRequest lanCreateRequest){
        Lan lan = convertToEntity(lanCreateRequest);
        Lan savedLan = lanService.save(lan);
        return convertToDTO(savedLan);
    }

    @PutMapping ("/{id}")
    public LanResponse editLan (@PathVariable Long id, @RequestBody LanEditRequest lanEditRequest){
        Lan lan = convertToEntity(lanEditRequest);
        lan.setId(id);
        Lan updatedLan = lanService.save(lan);
        return convertToDTO(updatedLan);
    }

    @DeleteMapping ("/{id}")
    public LanDeleteResponse deleteLan (@PathVariable Long id){
        lanService.deleteById(id);
        LanDeleteResponse response = new LanDeleteResponse();
        response.setId(id);
        response.setMessage("Lan eliminato");
        return response;
    }

    private LanResponse convertToDTO (Lan lan){
        LanResponse dto = new LanResponse();
        dto.setId(lan.getId());
        dto.setAvailable(lan.isAvailable());
        dto.setBookingList(lan.getBookingList());
        return dto;
    }

    private Lan convertToEntity (LanCreateRequest dto){
        return new Lan(dto.isAvailable(), dto.getBookingList());
    }

    private Lan convertToEntity (LanEditRequest dto){
        return new Lan(dto.isAvailable(), dto.getBookingList());
    }

    @PutMapping("/lanbooking")
    public LanResponse lanBooking () {
        List<Lan> lanList = lanService.findAvailable();
        if (!lanList.isEmpty()) {
            Lan lan = lanList.get(0);
            lan.setAvailable(false);
            Lan updatedLan = lanService.save(lan);
            return convertToDTO(updatedLan);
        } else {
            throw new EntityNotFoundException("Postazione non trovata");
        }
    }
}
