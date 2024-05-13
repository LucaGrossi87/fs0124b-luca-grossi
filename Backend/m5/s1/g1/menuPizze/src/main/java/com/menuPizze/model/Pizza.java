package com.menuPizze.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Pizza implements MenuItem {
    private String gusto;
    private double prezzo;
}
