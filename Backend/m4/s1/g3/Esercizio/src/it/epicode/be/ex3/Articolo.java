package it.epicode.be.ex3;

public class Articolo {
    private String codice, descrizione;
    private int prezzo, pezzi;

    public Articolo (String codice, String descrizione, int prezzo, int pezzi){
        this.codice=codice;
        this.descrizione=descrizione;
        this.prezzo=prezzo;
        this.pezzi=pezzi;
    }

    public String getDescrizione (){
        return descrizione;
    }

    public int getPrezzo (){
        return prezzo;
    }

    public String articolo() {
        return "L'articolo " + getDescrizione() + " cod." + codice + " al prezzo di " + getPrezzo() + "€ è disponibile in " + pezzi + " pezzi.";
    }
}
