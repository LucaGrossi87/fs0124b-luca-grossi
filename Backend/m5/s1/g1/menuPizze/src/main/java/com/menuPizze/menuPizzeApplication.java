package com.menuPizze;

import com.menuPizze.config.AppConfig;
import com.menuPizze.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.Scanner;

@SpringBootApplication
public class menuPizzeApplication {
	private static final Logger logger = LoggerFactory.getLogger(menuPizzeApplication.class);

	public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		SpringApplication.run(menuPizzeApplication.class, args);
		Scanner scanner = new Scanner(System.in);

		String aggiunta;
		double contoParziale = 0;
		logger.info("Numero tavolo:");
		int tavolo = scanner.nextInt();
		Tavolo nuovoTavolo = new Tavolo();
		nuovoTavolo.setNumero(tavolo);
		logger.info("Numero coperti:");
		int coperti = scanner.nextInt();
		nuovoTavolo.setPosti(coperti);
		Ordine nuovoOrdine = new Ordine();
		nuovoOrdine.setClienti(nuovoTavolo.getPosti());
		scanner.nextLine();
		do {
			logger.info("Aggiungi ordine o digita FINE per concludere l'ordine:");
			aggiunta = scanner.nextLine().toLowerCase().replaceAll("\\s+", "");
			if (!aggiunta.equalsIgnoreCase("fine")) {
				try {
					MenuItem menuItem = ctx.getBean(aggiunta, MenuItem.class);
					nuovoOrdine.aggiungiComanda(menuItem.getGusto());
					contoParziale+=menuItem.getPrezzo();
					logger.info("Conto parziale: {}", contoParziale);
				} catch (NoSuchBeanDefinitionException e) {
					logger.error("Aggiunta non presente");
				}
			}
		} while (!aggiunta.equalsIgnoreCase("fine"));

		double contoFinale = nuovoOrdine.aggiornaConto(contoParziale);
		logger.info("Coperti: {}", nuovoOrdine.getClienti());
		logger.info("Conto: {}", contoFinale);
		logger.info("Ordine: {}", nuovoOrdine.getComanda().toString());
		logger.info("Orario ordinazione: {}", LocalDateTime.now());


		Ordine.Stato statoOrdine = null;
		do {

		logger.info("Aggiorna stato: (1) In corso, (2) Pronto, (3) Servito)");
		int stato = scanner.nextInt();
		switch(stato) {
			case 1:
				statoOrdine= Ordine.Stato.IN_CORSO;
				break;
			case 2:
				statoOrdine= Ordine.Stato.PRONTO;
				break;
			case 3:
				statoOrdine= Ordine.Stato.SERVITO;
				break;
		}
		logger.info("L'ordine è {}", statoOrdine);
		} while (
			statoOrdine!= Ordine.Stato.SERVITO);
		}

	}