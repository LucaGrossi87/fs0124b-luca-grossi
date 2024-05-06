import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class LibroDAO {

    private EntityManager entityManager;

    public LibroDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void inserisciLibro(Libro libro) {
        entityManager.getTransaction().begin();
        entityManager.persist(libro);
        entityManager.getTransaction().commit();
    }

    public void rimuoviLibroPerISBN(String isbn) {
        entityManager.getTransaction().begin();
        Libro libro = entityManager.find(Libro.class, isbn);
        if (libro != null) {
            entityManager.remove(libro);
        }
        entityManager.getTransaction().commit();
    }

    public Libro cercaLibroPerISBN(String isbn) {
        return entityManager.find(Libro.class, isbn);
    }

    public List<Libro> cercaPerAutore(String autore) {
        Query query = entityManager.createQuery("SELECT l FROM Libro l WHERE l.autore = :autore");
        query.setParameter("autore", autore);
        return query.getResultList();
    }

    public List<Libro> cercaPerTitolo(String titolo) {
        Query query = entityManager.createQuery("SELECT l FROM Libro l WHERE l.titolo LIKE :titolo");
        query.setParameter("titolo", "%" + titolo + "%");
        return query.getResultList();
    }

    public List<Libro> cercaPerAnnoPubblicazione(int anno) {
        Query query = entityManager.createQuery("SELECT l FROM Libro l WHERE l.annoPubblicazione = :anno");
        query.setParameter("anno", anno);
        return query.getResultList();
    }

    public List<Libro> cercaLibriInPrestitoPerNumeroTessera(String numeroTessera) {
        Query query = entityManager.createQuery("SELECT p.elementoPrestato FROM Prestito p WHERE TYPE(p.elementoPrestato) = Libro AND p.utente.numeroTessera = :numeroTessera AND p.dataRestituzioneEffettiva IS NULL");
        query.setParameter("numeroTessera", numeroTessera);
        return query.getResultList();
    }

    public List<Libro> cercaLibriPrestitiScadutiNonRestituiti() {
        Query query = entityManager.createQuery("SELECT p.elementoPrestato FROM Prestito p WHERE TYPE(p.elementoPrestato) = Libro AND p.dataRestituzionePrevista < CURRENT_DATE AND p.dataRestituzioneEffettiva IS NULL");
        return query.getResultList();
    }

}
