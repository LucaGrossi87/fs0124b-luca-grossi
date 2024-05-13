package com.menuPizze;

import com.menuPizze.config.AppConfig;
import com.menuPizze.model.Drink;
import com.menuPizze.model.MenuItem;
import com.menuPizze.model.Pizza;
import com.menuPizze.model.Topping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.InvocationTargetException;

@SpringBootApplication
public class menuPizzeApplication {
	private static final Logger logger = LoggerFactory.getLogger(menuPizzeApplication.class);

	public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		SpringApplication.run(menuPizzeApplication.class, args);
//		logger.info("Pizze:");
//		Pizza margherita = (Pizza) ctx.getBean("margherita");
//		logger.info("{} {}€", margherita.getGusto(), margherita.getPrezzo());
//		Pizza diavola = (Pizza) ctx.getBean("diavola");
//		logger.info("{} {}€", diavola.getGusto(), diavola.getPrezzo());
//		Pizza fioriEAlici = (Pizza) ctx.getBean("fioriEAlici");
//		logger.info("{} {}€", fioriEAlici.getGusto(), fioriEAlici.getPrezzo());

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

}}
