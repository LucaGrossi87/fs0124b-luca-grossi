package com.example.demo.composite;

import com.example.demo.leaf.Pagina;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Sezione {
    private String title;
    private List<Pagina> pagine;
    private int numeroPagine;
}
