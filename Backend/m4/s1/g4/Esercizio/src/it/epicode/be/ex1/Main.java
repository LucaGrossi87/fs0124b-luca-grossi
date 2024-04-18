package it.epicode.be.ex1;

public class Main {
    public static void main(String[] args) {
        Dipendente dip1 = new Dipendente("194566", 1234.54, Dipendente.Dipartimento.PRODUZIONE);
        Dipendente dip2 = new Dipendente("984165", 1423.54, Dipendente.Dipartimento.AMMINISTRAZIONE);
        Dipendente dip3 = new Dipendente("048975", 1342.54, Dipendente.Dipartimento.VENDITE);
        Dipendente[] dipArr = {
                dip1,
                dip2,
                dip3
        };
        for (Dipendente dip : dipArr) {
            System.out.println(dip.getMatricola());
        }
    }
}