package com.example.demo.model;

import com.example.demo.abstracts.Ufficiale;

public class Generale extends Ufficiale {
    public Generale(String nome, double stipendio, String funzione, int importanza) {
        super(nome, stipendio, funzione, importanza);
    }
}