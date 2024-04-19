package it.epicode.be.elementoMultimediale;

public class Video extends ElementoMultimediale {
    private int luminosita;
    private int volume;

    public Video(String titolo, int durata, int luminosita, int volume) {
        super(titolo, durata);
        this.luminosita = luminosita;
        this.volume = volume;
    }

    public void aumentaLuminosita() {
        luminosita++;
    }

    public void diminuisciLuminosita() {
        if (luminosita > 0) {
            luminosita--;
        }
    }

    public void alzaVolume() {
        volume++;
    }

    public void abbassaVolume() {
        if (volume > 0) {
            volume--;
        }
    }

    @Override
    public void play() {
        if (isRiproducibile()) {
            for (int i = 0; i < getDurata(); i++) {
                System.out.print(getTitolo());
                for (int j = 0; j < volume; j++) {
                    System.out.print("!");
                }
                for (int k = 0; k < luminosita; k++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        } else {
            System.out.println("Video non valido");
        }
    }

}
