package it.epicode.be.elementoMultimediale;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ElementoMultimediale[] playlist = new ElementoMultimediale[5];

        for (int i = 0; i < playlist.length; i++) {
            int tipo;
            do {
                System.out.println("Seleziona elemento (1 = Audio, 2 = Video, 3 = Immagine):");
                tipo = scanner.nextInt();
                scanner.nextLine();
            } while (tipo < 1 || tipo > 3);

            System.out.println("Inserisci titolo:");
            String titolo = scanner.nextLine();

            if (tipo == 1) {
                System.out.println("Inserisci durata:");
                int durata = scanner.nextInt();
                System.out.println("Inserisci volume:");
                int volume = scanner.nextInt();
                playlist[i] = new Audio(titolo, durata, volume);
            } else if (tipo == 2) {
                System.out.println("Inserisci durata:");
                int durata = scanner.nextInt();
                System.out.println("Inserisci luminosità:");
                int luminosita = scanner.nextInt();
                System.out.println("Inserisci volume:");
                int volume = scanner.nextInt();
                playlist[i] = new Video(titolo, durata, luminosita, volume);
            } else if (tipo == 3) {
                System.out.println("Inserisci luminosità:");
                int luminosita = scanner.nextInt();
                playlist[i] = new Immagine(titolo, luminosita);
            }
        }

        int scelta;
        do {
            System.out.println("Seleziona elemento da 1 a 5, 0 per interrompere:");
            scelta = scanner.nextInt();
            if (scelta >= 1 && scelta <= 5) {
                ElementoMultimediale elementoScelto = playlist[scelta - 1];
                if (elementoScelto instanceof Audio || elementoScelto instanceof Video) {
                    elementoScelto.play();
                    System.out.println("Alza (+) o abbassa (-) (-) il volume (n per continuare)");
                    String opzioneVolume = scanner.next();
                    if (opzioneVolume.equals("+")) {
                        if (elementoScelto instanceof Audio) {
                            ((Audio) elementoScelto).alzaVolume();
                        } else if (elementoScelto instanceof Video) {
                            ((Video) elementoScelto).alzaVolume();
                        }
                    } else if (opzioneVolume.equals("-")) {
                        if (elementoScelto instanceof Audio) {
                            ((Audio) elementoScelto).abbassaVolume();
                        } else if (elementoScelto instanceof Video) {
                            ((Video) elementoScelto).abbassaVolume();
                        }
                    }
                    elementoScelto.play();
                }

                if (elementoScelto instanceof Video || elementoScelto instanceof Immagine) {
                    elementoScelto.play();
                    System.out.println("Alza (+) o abbassa (-) la luminosità (n per continuare)");
                    String opzioneLuminosita = scanner.next();
                    if (opzioneLuminosita.equals("+")) {
                        if (elementoScelto instanceof Video) {
                            ((Video) elementoScelto).aumentaLuminosita();
                        } else if (elementoScelto instanceof Immagine) {
                            ((Immagine) elementoScelto).aumentaLuminosita();
                        }
                    } else if (opzioneLuminosita.equals("-")) {
                        if (elementoScelto instanceof Video) {
                            ((Video) elementoScelto).diminuisciLuminosita();
                        } else if (elementoScelto instanceof Immagine) {
                            ((Immagine) elementoScelto).diminuisciLuminosita();
                        }
                    }
                    elementoScelto.play();
                }
            } else if (scelta != 0) {
                System.out.println("Scelta non valida.");
            }
        } while (scelta != 0);


        System.out.println("Fine.");
        scanner.close();
    }
}
