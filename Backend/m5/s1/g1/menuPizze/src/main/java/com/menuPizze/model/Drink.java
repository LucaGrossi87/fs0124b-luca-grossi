package com.menuPizze.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Drink implements MenuItem {
    private String gusto;
    private double prezzo;
}
