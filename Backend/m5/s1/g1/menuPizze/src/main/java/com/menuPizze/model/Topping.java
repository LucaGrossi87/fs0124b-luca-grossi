package com.menuPizze.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Topping implements MenuItem {
    private String gusto;
    private double prezzo;
}
