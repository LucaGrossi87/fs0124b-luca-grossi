package it.epicode.be.ex2;

public class ConsumiAuto {
    private int km;
    private int litri;

    public ConsumiAuto (int km, int litri){
        this.km=km;
        this.litri=litri;
    }

    public int calcolaConsumi (){
        return km/litri;
    }
}
