package com.GestionePrenotazioni.GestionePrenotazioni.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utente {

    @Id
    private String username;

    private String nomeCompleto;
    private String email;
}
