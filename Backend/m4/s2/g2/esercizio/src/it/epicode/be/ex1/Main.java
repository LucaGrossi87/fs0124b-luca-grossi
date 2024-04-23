package it.epicode.be.ex1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        do {
            logger.info("Inserisci il numero di elementi:");
            while (!scanner.hasNextInt()) {
                logger.info("Input non valido. Inserisci un numero intero:");
                scanner.next();
            }
            num = scanner.nextInt();
            scanner.nextLine();
        } while (num <= 0);

        Set<String> setInserimento = new LinkedHashSet<>();
        Set<String> setDuplicate = new LinkedHashSet<>();
        int count = 0;

        for (int i = 0; i < num; i++) {
            logger.info("Inserisci una stringa:");
            String newEl = scanner.nextLine();
            if (setInserimento.contains(newEl)) {
                logger.info("La parola '" + newEl + "' è già presente.");
                setDuplicate.add(newEl);
            } else {
                setInserimento.add(newEl);
                count++;
            }
        }

        logger.info("Hai inserito " + count + " parole valide.");
        logger.info("Parole valide inserite: " + setInserimento);
        logger.info("Hai inserito i seguenti duplicati: " + setDuplicate);
    }
}
