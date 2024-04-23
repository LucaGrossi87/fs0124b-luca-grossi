package it.epicode.be.ex2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        int num;
        String oddev;
        do {
            logger.info("Inserisci il numero di elementi:");
            while (!scanner.hasNextInt()) {
                logger.info("Input non valido. Inserisci un numero intero:");
                scanner.next();
            }
            num = scanner.nextInt();
            scanner.nextLine();
        } while (num <= 0);
        Ordinata newOrd = new Ordinata(num);
        List<Integer> newOrdList = newOrd.newOrd();
        logger.info(newOrdList.toString());
        Inverso newInv = new Inverso(newOrdList);
        List<Integer> newInvList = newInv.newInv(newOrdList);
        logger.info(newInvList.toString());
        logger.info("Vuoi visualizzare le posizioni pari (p) o dispari (d)?");
        oddev = scanner.next();
        if (oddev.equals("p")){
            OddEven newEvens = new OddEven(newOrdList, true);
        List<Integer> newEvensList = newEvens.oddOrEven(newOrdList, true);
        logger.info(newEvensList.reversed().toString());
        }else if (oddev.equals("d")){
            OddEven newEvens = new OddEven(newOrdList, false);
            List<Integer> newEvensList = newEvens.oddOrEven(newOrdList, false);
            logger.info(newEvensList.reversed().toString());
        } else {
            logger.info("Fine");
        }
    }
}
