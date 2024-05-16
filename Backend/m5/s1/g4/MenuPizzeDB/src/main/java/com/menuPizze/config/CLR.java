package com.menuPizze.config;

import com.menuPizze.menuPizzeApplication;
import com.menuPizze.model.Drink;
import com.menuPizze.model.MenuItem;
import com.menuPizze.model.Pizza;
import com.menuPizze.model.Topping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import com.menuPizze.repository.MenuItemRepository;

import java.awt.*;
import java.util.List;

@Component
public class CLR implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(menuPizzeApplication.class);

    @Autowired
    private MenuItemRepository menuItemRepository;

    private JdbcTemplate temp;

    public CLR(JdbcTemplate temp) {
        this.temp = temp;
    }

    public void insert(MenuItem item){
        temp.update("insert into pizza (gusto, prezzo) values (?,?)",
                item.getGusto(), item.getPrezzo());
    };

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

//        insert((MenuItem) ctx.getBean("margherita"));

        logger.info("Pizze:");
        for (String item : ctx.getBeanNamesForType(MenuItem.class)){
            MenuItem items = (MenuItem) ctx.getBean(item);
            if(items instanceof Pizza){
                logger.info("{} {}€", items.getGusto(), items.getPrezzo());
//                insert(items);
            }
        }

        logger.info("");

        logger.info("Toppings:");
        for (String item : ctx.getBeanNamesForType(MenuItem.class)){
            MenuItem items = (MenuItem) ctx.getBean(item);
            if(items instanceof Topping){
                logger.info("{} {}€", items.getGusto(), items.getPrezzo());
//                insert(items);
            }


        }
        logger.info("");

        logger.info("Drinks:");
        for (String item : ctx.getBeanNamesForType(MenuItem.class)){
            MenuItem items = (MenuItem) ctx.getBean(item);
            if(items instanceof Drink){
                logger.info("{} {}€", items.getGusto(), items.getPrezzo());
//                insert(items);
            }
        }

//        List<MenuItem> margherita = menuItemRepository.findByGusto("margherita");
//        for (MenuItem item : margherita){
//            logger.info(item.getGusto(), item.getPrezzo());
//        }
    }
}
