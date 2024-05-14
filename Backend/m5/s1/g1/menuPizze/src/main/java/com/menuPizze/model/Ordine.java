package com.menuPizze.model;

import com.menuPizze.config.AppConfig;
import lombok.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Ordine {
    private Tavolo tavolo;
    private List<String> comanda;
    private int clienti;
    private LocalDate ora;
    public enum Stato {
        IN_CORSO,
        PRONTO,
        SERVITO
    }
    private double importo=0;


    public Ordine() {
        this.comanda = new ArrayList<>();
    }

    public List<MenuItem> aggiungiComanda(String add) {
        comanda.add(add);
        return List.of();
    }

    public double aggiornaConto(double bill) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("Costo coperto :" + ctx.getBean("costoCoperto", Integer.class));
        importo += bill + (getClienti() * ctx.getBean("costoCoperto", Integer.class));
        return importo;
    }

}
