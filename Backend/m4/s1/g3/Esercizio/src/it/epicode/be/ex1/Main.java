package it.epicode.be.ex1;

public class Main {

    public static void main(String[] args){
        Rettangolo rett1 = new Rettangolo(7,11);
        Rettangolo rett2 = new Rettangolo(5,17);
        DueRettangoli dueRett = new DueRettangoli(rett1,rett2);
        System.out.println(rett1.stampaRettangolo());
        System.out.println(rett2.stampaRettangolo());
        System.out.println(dueRett.primoRett());
        System.out.println(dueRett.secondoRett());
        System.out.println(dueRett.combinaRett());
    }
}
