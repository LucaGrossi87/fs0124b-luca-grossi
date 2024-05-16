package com.menuPizze.config;

import com.menuPizze.model.Drink;
import com.menuPizze.model.Pizza;
import com.menuPizze.model.Topping;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
@Configuration
public class AppConfig {

    @Bean
    public Pizza margherita(){
        Pizza margherita = new Pizza(0,"gusto", 0);
        margherita.setGusto("Margherita");
        margherita.setPrezzo(5);
        return margherita;
    }

    @Bean
    public Pizza diavola(){
        Pizza diavola = new Pizza(0,"gusto", 0);
        diavola.setGusto("Diavola");
        diavola.setPrezzo(6);
        return diavola;
    }

    @Bean
    public Pizza fioriealici(){
        Pizza fioriEAlici = new Pizza(0,"gusto", 0);
        fioriEAlici.setGusto("Fiori e alici");
        fioriEAlici.setPrezzo(7);
        return fioriEAlici;
    }

    @Bean
    public Topping doppioformaggio(){
        Topping doppioFormaggio = new Topping(0,"Doppio formaggio",1.50);
        return doppioFormaggio;
    }

    @Bean
    public Topping piccante(){
        Topping piccate = new Topping(0,"Piccante",1.20);
        return piccate;
    }

    @Bean
    public Topping doppiosalame(){
        Topping doppioSalame = new Topping(0,"Doppio salame",2);
        return doppioSalame;
    }

    @Bean
    public Drink birra(){
        return new Drink(0,"Birra",5);
    }

    @Bean
    public Drink cocacola(){
        return new Drink(0,"Coca Cola",3);
    }

    @Bean
    public Drink acqua(){
        return new Drink(0,"Acqua",1);
    }

    @Value("${spring.application.coperto}")
    private int costoCoperto;

    @Bean
    public int costoCoperto() {
        return costoCoperto;
    }

}
