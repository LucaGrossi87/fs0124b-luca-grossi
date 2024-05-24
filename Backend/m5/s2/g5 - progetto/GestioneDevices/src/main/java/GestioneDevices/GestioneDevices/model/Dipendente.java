package GestioneDevices.GestioneDevices.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String nome;

    @NotBlank
    private String cognome;

    @Email
    @NotBlank
    private String email;

    private String imageUrl;

    @OneToMany(mappedBy = "dipendente", cascade = CascadeType.ALL)
    private List<Dispositivo> dispositivi;

}
