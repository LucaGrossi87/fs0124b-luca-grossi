package it.epicode.be.ex2;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;

public class Main {
        private static final Logger logger= LoggerFactory.getLogger(Main.class);
    public static void main (String[] args){
        Scanner scanner =new Scanner (System.in);
        int km = 0;
        int litri = 0;
        boolean erroreLitri = false;
        do {
            try {
                System.out.println("Inserisci km percorsi");
                km = scanner.nextInt();
                System.out.println("Inserisci litri consumati");
                litri = scanner.nextInt();
                if (litri <= 0) {
                    throw new LitriException("Calcolo errato");
                }
                int consu1 = new ConsumiAuto(km, litri).calcolaConsumi();
                System.out.println("I tuoi consumi sono stati: " + consu1 + " km/l");
            } catch (LitriException ex) {
                erroreLitri=true;
                logger.error("Calcolo errato");
            }
        } while (km>0&&!erroreLitri);
    }
}
