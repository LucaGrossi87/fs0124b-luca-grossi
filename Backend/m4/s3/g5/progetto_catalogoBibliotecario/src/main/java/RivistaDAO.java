import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class RivistaDAO {

    private EntityManager entityManager;

    public RivistaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void inserisciRivista(Rivista rivista) {
        entityManager.getTransaction().begin();
        entityManager.persist(rivista);
        entityManager.getTransaction().commit();
    }

    public void rimuoviRivistaPerISBN(String isbn) {
        entityManager.getTransaction().begin();
        Rivista rivista = entityManager.find(Rivista.class, isbn);
        if (rivista != null) {
            entityManager.remove(rivista);
        }
        entityManager.getTransaction().commit();
    }

    public Rivista cercaRivistaPerISBN(String isbn) {
        return entityManager.find(Rivista.class, isbn);
    }

    public List<Rivista> cercaPerPeriodicita(Rivista.Periodicita periodicita) {
        Query query = entityManager.createQuery("SELECT r FROM Rivista r WHERE r.periodicita = :periodicita");
        query.setParameter("periodicita", periodicita);
        return query.getResultList();
    }

    public List<Rivista> cercaPerTitolo(String titolo) {
        Query query = entityManager.createQuery("SELECT r FROM Rivista r WHERE r.titolo LIKE :titolo");
        query.setParameter("titolo", "%" + titolo + "%");
        return query.getResultList();
    }

    public List<Rivista> cercaPerAnnoPubblicazione(int anno) {
        Query query = entityManager.createQuery("SELECT r FROM Rivista r WHERE r.annoPubblicazione = :anno");
        query.setParameter("anno", anno);
        return query.getResultList();
    }

    public List<Rivista> cercaRivisteInPrestitoPerNumeroTessera(String numeroTessera) {
        Query query = entityManager.createQuery("SELECT p.elementoPrestato FROM Prestito p WHERE TYPE(p.elementoPrestato) = Rivista AND p.utente.numeroTessera = :numeroTessera AND p.dataRestituzioneEffettiva IS NULL");
        query.setParameter("numeroTessera", numeroTessera);
        return query.getResultList();
    }

    public List<Rivista> cercaRivistePrestitiScadutiNonRestituiti() {
        Query query = entityManager.createQuery("SELECT p.elementoPrestato FROM Prestito p WHERE TYPE(p.elementoPrestato) = Rivista AND p.dataRestituzionePrevista < CURRENT_DATE AND p.dataRestituzioneEffettiva IS NULL");
        return query.getResultList();
    }

}
