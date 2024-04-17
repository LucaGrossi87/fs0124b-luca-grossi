package it.epicode.be.ex1;

public class Rettangolo {
    private int height, width;

    public Rettangolo (int height, int width){
        this.height = height;
        this.width = width;
    }

    public int perimetro (){
        return (width + height)*2;
    }

    public int area (){
        return width*height;
    }

    public String stampaRettangolo (){
        return "Il perimetro è " + perimetro() + " e l'area è " + area();
    }

}
