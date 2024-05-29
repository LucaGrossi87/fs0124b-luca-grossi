package com.example.demo.abstracts;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public abstract class Ufficiale {
    private String nome;
    private double stipendio;
    private String funzione;
    private int importanza;
    private Ufficiale responsabile;

    public Ufficiale(String nome, double stipendio, String funzione, int importanza) {
        this.nome = nome;
        this.stipendio = stipendio;
        this.funzione = funzione;
        this.importanza = importanza;
    }
}
