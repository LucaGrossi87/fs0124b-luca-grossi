package it.epicode.be.elementoMultimediale;

public class Immagine extends ElementoMultimediale {
    private int luminosita;

    public Immagine(String titolo, int luminosita) {
        super(titolo, 0);
        this.luminosita = luminosita;
    }

    @Override
    public void play() {
        show();
    }

    public void show() {
        System.out.print(getTitolo());
        for (int i = 0; i < luminosita; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public void aumentaLuminosita() {
        luminosita++;
    }

    public void diminuisciLuminosita() {
        if (luminosita > 0) {
            luminosita--;
        }
    }
}
