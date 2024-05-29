package com.example.demo.model;

import com.example.demo.abstracts.Ufficiale;

public class Tenente extends Ufficiale {
    public Tenente(String nome, double stipendio, String funzione, int importanza) {
        super(nome, stipendio, funzione, importanza);
    }
}