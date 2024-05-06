import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UtenteDAO {

    private EntityManager entityManager;

    public UtenteDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void inserisciUtente(Utente utente) {
        entityManager.getTransaction().begin();
        entityManager.persist(utente);
        entityManager.getTransaction().commit();
    }

    public void rimuoviUtentePerNumeroTessera(String numeroTessera) {
        entityManager.getTransaction().begin();
        Utente utente = entityManager.find(Utente.class, numeroTessera);
        if (utente != null) {
            entityManager.remove(utente);
        }
        entityManager.getTransaction().commit();
    }

    public Utente cercaUtentePerNumeroTessera(String numeroTessera) {
        return entityManager.find(Utente.class, numeroTessera);
    }

    public List<Utente> cercaPerNome(String nome) {
        Query query = entityManager.createQuery("SELECT u FROM Utente u WHERE u.nome LIKE :nome");
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }

    public List<Utente> cercaPerCognome(String cognome) {
        Query query = entityManager.createQuery("SELECT u FROM Utente u WHERE u.cognome LIKE :cognome");
        query.setParameter("cognome", "%" + cognome + "%");
        return query.getResultList();
    }

    public List<Utente> cercaPerDataNascita(int anno, int mese, int giorno) {
        Query query = entityManager.createQuery("SELECT u FROM Utente u WHERE YEAR(u.dataNascita) = :anno AND MONTH(u.dataNascita) = :mese AND DAY(u.dataNascita) = :giorno");
        query.setParameter("anno", anno);
        query.setParameter("mese", mese);
        query.setParameter("giorno", giorno);
        return query.getResultList();
    }

}
