import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<ElementoCatalogo> catalogo = new ArrayList<>();

        while (true) {
            stampaCatalogo(catalogo);

            logger.info("1 Aggiungi elemento");
            logger.info("2 Elimina elemento per ISBN");
            logger.info("3 Ricerca per ISBN");
            logger.info("4 Ricerca per anno di pubblicazione");
            logger.info("5 Ricerca per autore");
            logger.info("6 Salva catalogo");
            logger.info("7 Carica catalogo");
            logger.info("8 Esci");

            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    aggiungiElemento(catalogo);
                    break;
                case 2:
                    rimuoviElementoPerISBN(catalogo);
                    break;
                case 3:
                    ricercaPerISBN(catalogo);
                    break;
                case 4:
                    ricercaPerAnno(catalogo);
                    break;
                case 5:
                    ricercaPerAutore(catalogo);
                    break;
                case 6:
                    salvaSuDisco(catalogo, "saves/catalogo.dat");
                    break;
                case 7:
                    catalogo = caricaDaDisco("saves/catalogo.dat");
                    break;
                case 8:
                    logger.info("FINE");
                    return;
                default:
                    logger.info("Errore. Ripeti.");
            }
        }
    }

    private static void aggiungiElemento(List<ElementoCatalogo> catalogo) {
        logger.info("Inserisci dati:");

        logger.info("ISBN: ");
        String isbn = scanner.nextLine();

        boolean isbnPresente = catalogo.stream().anyMatch(e -> e.getIsbn().equals(isbn));

        if (isbnPresente) {
            logger.info("L'ISBN deve essere univoco, riprova.");
            return;
        }

        logger.info("Titolo: ");
        String titolo = scanner.nextLine();

        logger.info("Anno di pubblicazione: ");
        int anno = scanner.nextInt();
        scanner.nextLine();

        logger.info("Numero pagine: ");
        int pagine = scanner.nextInt();
        scanner.nextLine();

        logger.info("Autore (Libro): ");
        String autore = scanner.nextLine();

        logger.info("Genere (Libro): ");
        String genere = scanner.nextLine();

        logger.info("Perodicità (Rivista) (scegli tra: SETTIMANALE, MENSILE, SEMESTRALE): ");
        String periodicitaInput = scanner.nextLine();

        if (!autore.isEmpty() && !genere.isEmpty()) {
            Libro libro = new Libro(isbn, titolo, anno, pagine, autore, genere);
            catalogo.add(libro);
        } else if (!periodicitaInput.isEmpty()) {
            try {
                Rivista.Periodicita periodicita = Rivista.Periodicita.valueOf(periodicitaInput.toUpperCase());
                Rivista rivista = new Rivista(isbn, titolo, anno, pagine, periodicita);
                catalogo.add(rivista);
            } catch (IllegalArgumentException e) {
                logger.error("Errore. Ripeti.");
            }
        } else {
            logger.info("Errore. Ripeti.");
        }
    }

    private static void rimuoviElementoPerISBN(List<ElementoCatalogo> catalogo) {
        logger.info("ISBN: ");
        String isbn = scanner.nextLine();

        Optional<ElementoCatalogo> elementoDaRimuovere = catalogo.stream()
                .filter(e -> e.getIsbn().equals(isbn))
                .findFirst();

        elementoDaRimuovere.ifPresentOrElse(
                catalogo::remove,
                () -> logger.info("Elemento " + isbn + " non trovato.")
        );
    }

    private static void ricercaPerISBN(List<ElementoCatalogo> catalogo) {
        logger.info("ISBN: ");
        String isbn = scanner.nextLine();

        Optional<ElementoCatalogo> elemento = catalogo.stream()
                .filter(e -> e.getIsbn().equals(isbn))
                .findFirst();

        elemento.ifPresentOrElse(
                e -> logger.info("Risultato: " + e),
                () -> logger.info("Elemento " + isbn + " non trovato.")
        );
    }

    private static void ricercaPerAnno(List<ElementoCatalogo> catalogo) {
        logger.info("Anno: ");
        int anno = scanner.nextInt();
        scanner.nextLine();

        List<ElementoCatalogo> elementi = catalogo.stream()
                .filter(e -> e.getAnno() == anno)
                .toList();

        if (elementi.isEmpty()) {
            logger.info("Nessun elemento trovato.");
        } else {
            logger.info("Risultato: " + elementi);
        }
    }

    private static void ricercaPerAutore(List<ElementoCatalogo> catalogo) {
        logger.info("Autore: ");
        String autore = scanner.nextLine();

        List<ElementoCatalogo> elementi = catalogo.stream()
                .filter(e -> e instanceof Libro)
                .filter(e -> ((Libro) e).getAutore().equals(autore))
                .toList();

        if (elementi.isEmpty()) {
            logger.info("Nessun elemento trovato.");
        } else {
            logger.info("Risultato: " + elementi);
        }
    }

    private static void salvaSuDisco(List<ElementoCatalogo> catalogo, String nomeFile) {
        try {
            File file = new File(nomeFile);
            FileUtils.writeByteArrayToFile(file, serialize(catalogo));
            logger.info("Catalogo salvato.");
        } catch (IOException e) {
            logger.error("Errore durante il salvataggio");
        }
    }

    private static List<ElementoCatalogo> caricaDaDisco(String nomeFile) {
        try {
            File file = new File(nomeFile);
            byte[] data = FileUtils.readFileToByteArray(file);
            return deserialize(data);
        } catch (IOException | ClassNotFoundException e) {
            logger.error("Errore durante il caricamento");
            return new ArrayList<>();
        }
    }

    private static byte[] serialize(List<ElementoCatalogo> catalogo) throws IOException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(catalogo);
            return bos.toByteArray();
        }
    }

    private static List<ElementoCatalogo> deserialize(byte[] data) throws IOException, ClassNotFoundException {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(data);
             ObjectInputStream ois = new ObjectInputStream(bis)) {
            return (List<ElementoCatalogo>) ois.readObject();
        }
    }

    private static void stampaCatalogo(List<ElementoCatalogo> catalogo) {
        if (catalogo.isEmpty()) {
            logger.info("Catalogo vuoto.");
        } else {
            logger.info("Catalogo aggiornato:");
            catalogo.forEach(e -> logger.info(e.toString()));
        }
    }
}
