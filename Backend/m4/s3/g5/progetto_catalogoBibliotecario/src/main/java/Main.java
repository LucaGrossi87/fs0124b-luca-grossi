import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA_Sample");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Scanner scanner = new Scanner(System.in);

        ElementoCatalogoDAO elementoCatalogoDAO = new ElementoCatalogoDAO(entityManager);
        LibroDAO libroDAO = new LibroDAO(entityManager);

        Utente utente1 = new Utente("Nome1", "Cognome1", new Date(), "12345");
        Utente utente2 = new Utente("Nome2", "Cognome2", new Date(), "67890");

        UtenteDAO utenteDAO = new UtenteDAO(entityManager);
        utenteDAO.inserisciUtente(utente1);
        utenteDAO.inserisciUtente(utente2);

        ElementoCatalogo elemento1 = new Libro("ISBN1", "Titolo1", 2020, 200, "Autore1", "Genere1");
        ElementoCatalogo elemento2 = new Rivista("ISBN2", "Titolo2", 2021, 100, Rivista.Periodicita.MENSILE);

        elementoCatalogoDAO.inserisciElemento(elemento1);
        elementoCatalogoDAO.inserisciElemento(elemento2);

        Prestito prestito1 = new Prestito(utente1, elemento1, new Date());
        Prestito prestito2 = new Prestito(utente2, elemento2, new Date());

        PrestitoDAO prestitoDAO = new PrestitoDAO(entityManager);
        prestitoDAO.registraPrestito(prestito1);
        prestitoDAO.registraPrestito(prestito2);

        prestitoDAO.registraRestituzione(prestito1);


        while (true) {
            logger.info("1. Inserire un elemento nel catalogo");
            logger.info("2. Rimuovere un elemento dal catalogo per ISBN");
            logger.info("3. Ricerca per ISBN");
            logger.info("4. Ricerca per anno di pubblicazione");
            logger.info("5. Ricerca per autore (solo libri)");
            logger.info("6. Ricerca per titolo o parte di esso");
            logger.info("7. Ricerca degli elementi in prestito attualmente tramite numero tessera utente");
            logger.info("8. Ricerca dei prestiti scaduti e non ancora restituiti");
            logger.info("9. Esci");

            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    inserisciElemento(scanner, elementoCatalogoDAO);
                    break;
                case 2:
                    rimuoviElementoPerISBN(scanner, elementoCatalogoDAO);
                    break;
                case 3:
                    ricercaPerISBN(scanner, elementoCatalogoDAO);
                    break;
                case 4:
                    ricercaPerAnnoPubblicazione(scanner, elementoCatalogoDAO);
                    break;
                case 5:
                    ricercaPerAutore(scanner, libroDAO);
                    break;
                case 6:
                    ricercaPerTitolo(scanner, elementoCatalogoDAO);
                    break;
                case 7:
                    ricercaElementiInPrestitoPerNumeroTessera(scanner, prestitoDAO);
                    break;
                case 8:
                    ricercaPrestitiScadutiNonRestituiti(prestitoDAO);
                    break;
                case 9:
                    logger.info("FINE");
                    entityManager.close();
                    entityManagerFactory.close();
                    return;
                default:
                    logger.info("Riprova");
            }
        }
    }

    private static void inserisciElemento(Scanner scanner, ElementoCatalogoDAO elementoCatalogoDAO) {
        logger.info("ISBN:");
        String isbn = scanner.nextLine();
        logger.info("Titolo:");
        String titolo = scanner.nextLine();
        logger.info("Anno di pubblicazione:");
        int annoPubblicazione = scanner.nextInt();
        scanner.nextLine();

        logger.info("Numero pagine:");
        int numeroPagine = scanner.nextInt();
        scanner.nextLine();

        logger.info("lIBRO(1) o RIVISTA (2):");
        int tipoElemento = scanner.nextInt();
        scanner.nextLine();

        if (tipoElemento == 1) {
            logger.info("Autore:");
            String autore = scanner.nextLine();
            logger.info("Genere:");
            String genere = scanner.nextLine();

            Libro libro = new Libro(isbn, titolo, annoPubblicazione, numeroPagine, autore, genere);
            elementoCatalogoDAO.inserisciElemento(libro);
        } else if (tipoElemento == 2) {
            logger.info("Periodicita (SETTIMANALE, MENSILE, SEMESTRALE):");
            String periodicitaString = scanner.nextLine().toUpperCase();
            Rivista.Periodicita periodicita = Rivista.Periodicita.valueOf(periodicitaString);

            Rivista rivista = new Rivista(isbn, titolo, annoPubblicazione, numeroPagine, periodicita);
            elementoCatalogoDAO.inserisciElemento(rivista);
        } else {
            logger.info("Errore");
        }
    }

    private static void rimuoviElementoPerISBN(Scanner scanner, ElementoCatalogoDAO elementoCatalogoDAO) {
        logger.info("Inserisci ISBN:");
        String isbn = scanner.nextLine();
        elementoCatalogoDAO.rimuoviElementoPerISBN(isbn);
        logger.info("Elemento rimosso");
    }

    private static void ricercaPerISBN(Scanner scanner, ElementoCatalogoDAO elementoCatalogoDAO) {
        logger.info("Inserisci l'ISBN:");
        String isbn = scanner.nextLine();
        ElementoCatalogo elemento = elementoCatalogoDAO.cercaPerISBN(isbn);
        if (elemento != null) {
            logger.info(elemento.toString());
        } else {
            logger.info("Nessun elemento trovato");
        }
    }

    private static void ricercaPerAnnoPubblicazione(Scanner scanner, ElementoCatalogoDAO elementoCatalogoDAO) {
        logger.info("Inserisci l'anno di pubblicazione:");
        int anno = scanner.nextInt();
        scanner.nextLine();

        List<ElementoCatalogo> elementi = elementoCatalogoDAO.cercaPerAnnoPubblicazione(anno);
        if (!elementi.isEmpty()) {
            for (ElementoCatalogo elemento : elementi) {
                logger.info(elemento.toString());
            }
        } else {
            logger.info("Nessun elemento trovato");
        }
    }

    private static void ricercaPerAutore(Scanner scanner, LibroDAO libroDAO) {
        logger.info("Inserisci autore:");
        String autore = scanner.nextLine();

        List<Libro> libri = libroDAO.cercaPerAutore(autore);
        if (!libri.isEmpty()) {
            for (Libro libro : libri) {
                logger.info(libro.toString());
            }
        } else {
            logger.info("Nessun libro trovato");
        }
    }

    private static void ricercaPerTitolo(Scanner scanner, ElementoCatalogoDAO elementoCatalogoDAO) {
        logger.info("Inserisci titolo:");
        String titolo = scanner.nextLine();

        List<ElementoCatalogo> elementi = elementoCatalogoDAO.cercaPerTitolo(titolo);
        if (!elementi.isEmpty()) {
            for (ElementoCatalogo elemento : elementi) {
                logger.info(elemento.toString());
            }
        } else {
            logger.info("Nessun elemento trovato");
        }
    }

    private static void ricercaElementiInPrestitoPerNumeroTessera(Scanner scanner, PrestitoDAO prestitoDAO) {
        logger.info("Inserisci numero tessera dell'utente:");
        String numeroTessera = scanner.nextLine();

        List<Prestito> prestiti = prestitoDAO.cercaPrestitiPerNumeroTessera(numeroTessera);
        if (!prestiti.isEmpty()) {
            for (Prestito prestito : prestiti) {
                logger.info(prestito.toString());
            }
        } else {
            logger.info("Nessun prestito trovato");
        }
    }

    private static void ricercaPrestitiScadutiNonRestituiti(PrestitoDAO prestitoDAO) {
        List<Prestito> prestiti = prestitoDAO.cercaPrestitiScadutiNonRestituiti();
        if (!prestiti.isEmpty()) {
            for (Prestito prestito : prestiti) {
                logger.info(prestito.toString());
            }
        } else {
            logger.info("Nessun prestito scaduto e non restituito trovato.");
        }
    }


}
