import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonaDAO {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Sample");
    EntityManager em = emf.createEntityManager();

    public void salvaPersona(Persona persona) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(persona);
            transaction.commit();
        } finally {
            em.close();
        }
    }

    public Persona cercaPersona(long id) {
        try {
            return em.find(Persona.class, id);
        } finally {
            em.close();
        }
    }

    public void eliminaPersona(long id) {
        try {
            Persona persona = em.find(Persona.class, id);
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(persona);
            transaction.commit();
        } finally {
            em.close();
        }
    }
}
