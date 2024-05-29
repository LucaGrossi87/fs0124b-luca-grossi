package com.example.demo.composite;

import com.example.demo.DemoApplication;
import com.example.demo.interf.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Libro implements Component {

    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    private String title;
    private List<String> authors=new ArrayList<>();
    private List<Sezione> sections;
    private double price;
    private int pagesNum;

    @Override
    public void mostraDettagli() {
        logger.info("Titolo " + title + "; Autore/i " + authors.toString() + "; Numero di Pagine: " + pagesNum + ", Sezioni: " + sections.toString() + "; Prezzo: " + price);
    }
}
