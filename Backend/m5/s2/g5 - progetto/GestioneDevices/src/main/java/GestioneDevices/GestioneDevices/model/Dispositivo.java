package GestioneDevices.GestioneDevices.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
@Entity
public class Dispositivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String tipo;

    @NotBlank
    private DispositivoStatus status;

    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;

}
