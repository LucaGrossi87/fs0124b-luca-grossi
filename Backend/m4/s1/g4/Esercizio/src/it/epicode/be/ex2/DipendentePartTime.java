package it.epicode.be.ex2;

public class DipendentePartTime extends Dipendente{
    private double workingHours;
    public DipendentePartTime(String matricola, double stipendio, Dipartimento dipartimento, double workingHours) {
        super(matricola, stipendio, dipartimento);
        this.workingHours=workingHours;
    }


    public double calculateSalary(){
        return super.getStipendio()*workingHours;
    }
}
