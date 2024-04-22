package it.epicode.be.ex1;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner (System.in);
    public static void main (String[] args) throws NumberOutOfBoundException, PositionOutOfBoundException {
        int[] arr1 = new RandomArray().fillArray();
        System.out.println("L'array generato è: ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }

        int num;
        do {
            System.out.println("Scegli un numero da inserire");
            num = scanner.nextInt();
            System.out.println("Scegli in che posizione inserirlo");
            int pos = scanner.nextInt();

            if (num > 0 && num <= 10 && pos >= 0 && pos < arr1.length) {
                arr1[pos - 1] = num;
            } else if (num < 0 || num > 10){
                System.out.println("Numero errato");
                throw new NumberOutOfBoundException("Numero errato");
            } else if (pos < 0 || pos >= arr1.length) {
                System.out.println("Posizione errata");
                throw new PositionOutOfBoundException("Posizione errata");
            }

            System.out.println("L'array aggiornato è: ");
            for (int i = 0; i < arr1.length; i++) {
                System.out.println(arr1[i]);
            }
        } while (num != 0);
    }
}
