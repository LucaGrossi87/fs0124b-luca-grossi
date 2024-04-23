package it.epicode.be.ex3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(it.epicode.be.ex2.Main.class);
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> contactList = new HashMap<>(Map.of());
        String keepIns;
        String op;
        do {
            logger.info("Inserisci nuovo nome");
            String newName = scanner.nextLine();
            logger.info("Inserisci nuovo numero");
            String newPhone = scanner.nextLine();
            contactList.put(newName, newPhone);
            logger.info(contactList.toString());
            logger.info("Vuoi inserire un nuovo contatto?y/n");
            keepIns = scanner.nextLine();
        } while (keepIns.equals("y"));
        if (keepIns.equals("n")){
        logger.info("(c) elimina contatto, (s) cerca contatto, (p) stampa lista contatti");
        op=scanner.nextLine();
        if (op.equals("c")){
            String name;
            logger.info("Inserisci nome da eliminare");
            name=scanner.nextLine();
            contactList.remove(name);
            logger.info(contactList.toString());
        } else if (op.equals("s")) {
            String ans;
            logger.info("Vuoi cercare per nome(n) o per numero(p)?");
            ans= scanner.nextLine();
            if (ans.equals("n")){
                logger.info("Inserire nome da cercare");
                String n=scanner.nextLine();
                logger.info(n+", " + contactList.get(n));
            } else if (ans.equals("p")){
                logger.info("Inserire numero da cercare");
                String p=scanner.nextLine();
                for (String name : contactList.keySet()){
                    String phone = contactList.get(name);
                    if (phone.equals(p)) {
                        logger.info(name + ", " + phone);
                    }
                }
    }
        } else if (op.equals("p")) {
            logger.info(contactList.toString());
        } else {
                logger.info("FINE");
            }
    } else {
            logger.info("FINE");
        }
}}

