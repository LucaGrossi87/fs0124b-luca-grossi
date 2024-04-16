package it.epicode.be.ex_for;

public class Ex_for {

    public static String countdown (int a) {
        String cntDwn = "";
        for (int i = a; i >= 0; i--) {
            cntDwn += i + " ";
        }
        return cntDwn;
    }

    public static void main (String[] args){
        System.out.println(countdown(7));
    }
}