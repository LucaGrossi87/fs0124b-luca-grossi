package it.epicode.be.ex3;

import java.util.Arrays;

public class Carrello {
    Cliente cl;
    Articolo[] art;

    public Carrello (Cliente cl, Articolo[] art){
        this.art= art;
        this.cl=cl;
    }

    public String artDescr () {
        String[] allDescr = new String[art.length];
        for (int i = 0; i < art.length; i++) {
            allDescr[i] = art[i].getDescrizione();
        }
        return String.join(", ", allDescr);
    }

    public int totCart () {
        int totCart = 0;
        for (int i = 0; i < art.length; i++) {
            totCart += art[i].getPrezzo();
        }
        return totCart;
    }


    public String Conto (){
        return "Cliente: " + cl.getNome() + "; Articoli nel carrello: " + artDescr()+ "; Totale Carrello: " + totCart() +"€" ;
    }

}