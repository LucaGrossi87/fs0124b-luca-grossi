package it.epicode.be.ex1;

public class DueRettangoli{
    private Rettangolo rett1, rett2;

    public DueRettangoli (Rettangolo rett1, Rettangolo rett2){
        this.rett1 = rett1;
        this.rett2 = rett2;
    }

    public String primoRett (){
        return "il primo rettangolo ha un'area di " + rett1.area() + " e un perimetro di " + rett1.perimetro();
    }

    public String secondoRett (){
        return "il secondo rettangolo ha un'area di " + rett2.area() + " e un perimetro di " + rett2.perimetro();
    }

    private int sommaArea (){
        return rett1.area()+rett2.area();
    }

    private int somma2P (){
        return rett1.perimetro()+rett2.perimetro();
    }


    public String combinaRett (){
        return "l'area totale dei rettangoli è " + sommaArea() + " e il perimetro totale è " + somma2P();
    }
}
