package com.menuPizze.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "pizza")
public class Pizza extends MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gusto;
    private double prezzo;

    public Pizza(long id, String gusto, double prezzo) {
        super(id, gusto, prezzo);
    }
}
