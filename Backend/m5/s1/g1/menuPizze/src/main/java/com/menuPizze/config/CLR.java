package com.menuPizze.config;

import com.menuPizze.menuPizzeApplication;
import com.menuPizze.model.Drink;
import com.menuPizze.model.MenuItem;
import com.menuPizze.model.Pizza;
import com.menuPizze.model.Topping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CLR implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(menuPizzeApplication.class);

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        logger.info("Pizze:");
        for (String item : ctx.getBeanNamesForType(MenuItem.class)){
            MenuItem items = (MenuItem) ctx.getBean(item);
            if(items instanceof Pizza){
                logger.info("{} {}€", items.getGusto(), items.getPrezzo());
            }
        }

        logger.info("");

        logger.info("Toppings:");
        for (String item : ctx.getBeanNamesForType(MenuItem.class)){
            MenuItem items = (MenuItem) ctx.getBean(item);
            if(items instanceof Topping){
                logger.info("{} {}€", items.getGusto(), items.getPrezzo());
            }


        }
        logger.info("");

        logger.info("Drinks:");
        for (String item : ctx.getBeanNamesForType(MenuItem.class)){
            MenuItem items = (MenuItem) ctx.getBean(item);
            if(items instanceof Drink){
                logger.info("{} {}€", items.getGusto(), items.getPrezzo());
            }
        }
    }
}
