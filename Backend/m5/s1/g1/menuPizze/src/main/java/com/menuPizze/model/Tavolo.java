package com.menuPizze.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Tavolo {
    private int numero;
    private int posti;
    private boolean isOccupato;
}
