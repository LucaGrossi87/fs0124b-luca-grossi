package it.epicode.be.ex_switch;

public class Ex_switch {

    public static String stringedNumber (int a) {
        switch(a) {
            case 0:
                return "zero";
            case 1:
                return "uno";
            case 2:
                return "due";
            case 3:
                return "tre";
            default:
                return "errore";
        }
    }

    public static void main (String[] args){
        System.out.println("Hai inserito il numero: " + stringedNumber(1));
    }
}