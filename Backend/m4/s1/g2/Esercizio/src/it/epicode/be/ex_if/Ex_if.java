package it.epicode.be.ex_if;

public class Ex_if {

    public static boolean pariDispari(String a) {
        return a.length() % 2 == 0;
    }

    public static boolean annoBisestile(int a) {
        if(a % 100 != 0) return a % 4 == 0;
        return a % 400 == 0;
    }

    public static void main (String[] args){
        System.out.println(pariDispari("casa"));
        System.out.println(annoBisestile(2001));
    }
}
