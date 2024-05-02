import jdk.jfr.Event;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocationDAO {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Sample");
    EntityManager em = emf.createEntityManager();

    public void salvaLocation(Location location) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(location);
            transaction.commit();
        }
        finally {
            em.close();
        }
    }
    public String cercaLocation(long id) {
        try {
            Location evento = em.find(Location.class, id);
            return evento.getNome();
        }
        finally {
            em.close();
        }
    }
    public void eliminaLocation(long id) {
        try {
            Location evento = em.find(Location.class, id);
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(evento);
            transaction.commit();
        }
        finally {
            em.close();
        }
    }
}
