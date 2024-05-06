import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ElementoCatalogoDAO {

    private EntityManager entityManager;

    public ElementoCatalogoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void inserisciElemento(ElementoCatalogo elemento) {
        entityManager.getTransaction().begin();
        entityManager.persist(elemento);
        entityManager.getTransaction().commit();
    }

    public void rimuoviElementoPerISBN(String isbn) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE FROM ElementoCatalogo ec WHERE ec.isbn = :isbn");
        query.setParameter("isbn", isbn);
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }


    public ElementoCatalogo cercaPerISBN(String isbn) {
        Query query = entityManager.createQuery("SELECT ec FROM ElementoCatalogo ec WHERE ec.isbn = :isbn", ElementoCatalogo.class);
        query.setParameter("isbn", isbn);
        return (ElementoCatalogo) query.getSingleResult();
    }


    public List<ElementoCatalogo> cercaPerAnnoPubblicazione(int anno) {
        Query query = entityManager.createQuery("SELECT e FROM ElementoCatalogo e WHERE e.annoPubblicazione = :anno");
        query.setParameter("anno", anno);
        return query.getResultList();
    }

    public List<Libro> cercaLibriPerAutore(String autore) {
        Query query = entityManager.createQuery("SELECT l FROM Libro l WHERE l.autore = :autore");
        query.setParameter("autore", autore);
        return query.getResultList();
    }

    public List<ElementoCatalogo> cercaPerTitolo(String titolo) {
        Query query = entityManager.createQuery("SELECT e FROM ElementoCatalogo e WHERE e.titolo LIKE :titolo");
        query.setParameter("titolo", "%" + titolo + "%");
        return query.getResultList();
    }

    public List<ElementoCatalogo> cercaElementiInPrestitoPerNumeroTessera(String numeroTessera) {
        Query query = entityManager.createQuery("SELECT p.elementoPrestato FROM Prestito p WHERE p.utente.numeroTessera = :numeroTessera AND p.dataRestituzioneEffettiva IS NULL");
        query.setParameter("numeroTessera", numeroTessera);
        return query.getResultList();
    }

    public List<Prestito> cercaPrestitiScadutiNonRestituiti() {
        Query query = entityManager.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzionePrevista < CURRENT_DATE AND p.dataRestituzioneEffettiva IS NULL");
        return query.getResultList();
    }
}
