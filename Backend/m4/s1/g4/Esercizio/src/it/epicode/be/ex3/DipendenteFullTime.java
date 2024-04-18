package it.epicode.be.ex3;

public class DipendenteFullTime extends Dipendente {

    public DipendenteFullTime(String matricola, double stipendio, Dipartimento dipartimento) {
        super(matricola, stipendio, dipartimento);
    }

    public double calculateSalary(){
        return super.getStipendio();
    }
}
