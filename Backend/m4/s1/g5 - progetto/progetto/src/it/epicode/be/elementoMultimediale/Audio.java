package it.epicode.be.elementoMultimediale;

public class Audio extends ElementoMultimediale {
    private int volume;

    public Audio(String titolo, int durata, int volume) {
        super(titolo, durata);
        this.volume = volume;
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
                System.out.println();
            }
        } else {
            System.out.println("Audio non valido");
        }
    }
}
