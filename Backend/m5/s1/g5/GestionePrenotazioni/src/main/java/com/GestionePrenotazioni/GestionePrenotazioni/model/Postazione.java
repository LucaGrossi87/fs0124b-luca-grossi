package com.GestionePrenotazioni.GestionePrenotazioni.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class Postazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codice;
    private String descrizione;

    @Enumerated(EnumType.STRING)
    private TipoPostazione tipo;

    private int capienza;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    public Postazione(String codice, String descrizione, TipoPostazione tipo, int capienza, Edificio edificio) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.capienza = capienza;
        this.edificio = edificio;
    }

    public enum TipoPostazione {
        PRIVATO,
        OPENSPACE,
        SALA_RIUNIONI
    }
}
