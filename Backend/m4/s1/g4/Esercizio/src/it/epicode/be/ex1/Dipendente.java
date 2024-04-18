package it.epicode.be.ex1;

public class Dipendente {
    private String matricola;
    private double stipendio;
    enum Dipartimento {
        PRODUZIONE,
        AMMINISTRAZIONE,
        VENDITE
    }
    private Dipartimento dipartimento;

    public String getMatricola() {
        return matricola;
    }

    public double getStipendio() {
        return stipendio;
    }

    public void setDipartimento (Dipartimento newDip){
        dipartimento=newDip;
    }

    public Dipendente (String matricola, double stipendio,Dipartimento dipartimento){
        this.matricola=matricola;
        this.stipendio=stipendio;
        this.dipartimento=dipartimento;
    }
}
