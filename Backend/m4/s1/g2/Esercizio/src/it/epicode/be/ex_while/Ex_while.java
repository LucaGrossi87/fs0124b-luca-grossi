package it.epicode.be.ex_while;

public class Ex_while {

    public static String charList (String a) {
        while(a!=":q") {
            String letters = "";
            for (int i = 0; i < a.length(); i++) {
                letters += a.toCharArray()[i] + ",";
            }
            return letters;
        }
        return "errore";
    }

    public static void main (String[] args){
        System.out.println(charList("supercalifragilistichespiralidoso"));
    }
}
