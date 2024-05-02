import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PartecipazioneDAO {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Sample");
    EntityManager em = emf.createEntityManager();

    public void salvaPartecipazione(Partecipazione partecipazione) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(partecipazione);
            transaction.commit();
        } finally {
            em.close();
        }
    }

    public Partecipazione cercaPartecipazione(long id) {
        try {
            return em.find(Partecipazione.class, id);
        } finally {
            em.close();
        }
    }

    public void eliminaPartecipazione(long id) {
        try {
            Partecipazione partecipazione = em.find(Partecipazione.class, id);
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(partecipazione);
            transaction.commit();
        } finally {
            em.close();
        }
    }
}
