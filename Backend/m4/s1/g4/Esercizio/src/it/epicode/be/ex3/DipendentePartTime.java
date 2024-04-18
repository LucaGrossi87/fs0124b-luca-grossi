package it.epicode.be.ex3;

public class DipendentePartTime extends Dipendente {
    double workingHours;
    public DipendentePartTime(String matricola, double stipendio, Dipartimento dipartimento, double workingHours) {
        super(matricola, stipendio, dipartimento);
        this.workingHours=workingHours;
    }


    public double calculateSalary(){
        return super.getStipendio()*workingHours;
    }
}
