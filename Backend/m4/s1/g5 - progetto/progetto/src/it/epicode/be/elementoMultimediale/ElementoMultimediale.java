package it.epicode.be.elementoMultimediale;

public abstract class ElementoMultimediale {
    private String titolo;
    private int durata; // Durata in secondi

    public ElementoMultimediale(String titolo, int durata) {
        this.titolo = titolo;
        this.durata = durata;
    }

    public boolean isRiproducibile() {
        return durata > 0;
    }

    public abstract void play();

    public String getTitolo() {
        return titolo;
    }

    public int getDurata() {
        return durata;
    }
}
