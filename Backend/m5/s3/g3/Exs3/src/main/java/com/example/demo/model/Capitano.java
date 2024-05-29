package com.example.demo.model;

import com.example.demo.abstracts.Ufficiale;

public class Capitano extends Ufficiale {
    public Capitano(String nome, double stipendio, String funzione, int importanza) {
        super(nome, stipendio, funzione, importanza);
    }
}