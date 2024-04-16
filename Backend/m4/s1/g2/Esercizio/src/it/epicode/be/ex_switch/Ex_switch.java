package it.epicode.be.ex_switch;

public class Ex_switch {

    public static String stringedNumber (int a) {
        switch(a) {
            case 0:
                return Integer.toString(a);
            case 1:
                return Integer.toString(a);
            case 2:
                return Integer.toString(a);
            case 3:
                return Integer.toString(a);
            default:
                return "errore";
        }
    }

    public static void main (String[] args){
        System.out.println("Hai inserito il numero: " + stringedNumber(3));
    }
}