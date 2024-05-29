package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class Info {
    private String nome;
    private String cognome;
    private Date dataDiNascita;

}
