package com.menuPizze.model;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
public class Topping extends MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gusto;
    private double prezzo;

    public Topping(long id ,String gusto, double prezzo) {
        super(id, gusto, prezzo);
    }
}
