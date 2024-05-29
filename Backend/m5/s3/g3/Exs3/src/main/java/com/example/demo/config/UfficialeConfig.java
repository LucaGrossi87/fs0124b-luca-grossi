package com.example.demo.config;

import com.example.demo.handler.*;
import com.example.demo.model.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UfficialeConfig {

    @Bean
    public Tenente tenente() {
        return new Tenente("Tenente", 1000, "Bassa", 1);
    }

    @Bean
    public Capitano capitano() {
        return new Capitano("Capitano", 2000, "Medio-Bassa", 2);
    }

    @Bean
    public Maggiore maggiore() {
        return new Maggiore("Maggiore", 3000, "Media", 3);
    }

    @Bean
    public Colonnello colonnello() {
        return new Colonnello("Colonnello", 4000, "Medio-Alta", 4);
    }

    @Bean
    public Generale generale() {
        return new Generale("Generale", 5000, "Alta", 5);
    }

    @Bean
    public UfficialeHandler chainOfResponsibility(Tenente tenente, Capitano capitano, Maggiore maggiore, Colonnello colonnello, Generale generale) {
        TenenteHandler tenenteHandler = new TenenteHandler(tenente);
        CapitanoHandler capitanoHandler = new CapitanoHandler(capitano);
        MaggioreHandler maggioreHandler = new MaggioreHandler(maggiore);
        ColonnelloHandler colonnelloHandler = new ColonnelloHandler(colonnello);
        GeneraleHandler generaleHandler = new GeneraleHandler(generale);

        tenenteHandler.setNextHandler(capitanoHandler);
        capitanoHandler.setNextHandler(maggioreHandler);
        maggioreHandler.setNextHandler(colonnelloHandler);
        colonnelloHandler.setNextHandler(generaleHandler);

        tenente.setResponsabile(capitano);
        capitano.setResponsabile(maggiore);
        maggiore.setResponsabile(colonnello);
        colonnello.setResponsabile(generale);

        return tenenteHandler;
    }
}
