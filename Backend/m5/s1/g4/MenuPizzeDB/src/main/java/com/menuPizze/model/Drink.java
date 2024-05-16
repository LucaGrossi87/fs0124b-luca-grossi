package com.menuPizze.model;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Setter
@ToString
public class Drink extends MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gusto;
    private double prezzo;

    public Drink(long id, String gusto, double prezzo) {
        super(id, gusto, prezzo);
    }
}
