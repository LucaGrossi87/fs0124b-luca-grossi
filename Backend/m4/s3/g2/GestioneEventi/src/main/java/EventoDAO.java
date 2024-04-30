import jdk.jfr.Event;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventoDAO {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Sample");
    EntityManager em = emf.createEntityManager();

    public void salvaEvento(Evento evento) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(evento);
            transaction.commit();
        }
            finally {
            em.close();
        }
    }
    public String cercaEvento(long id) {
        try {
            Evento evento = em.find(Evento.class, id);
            return evento.getDescrizione();
        }
        finally {
            em.close();
        }
    }
    public void eliminaEvento(long id) {
        try {
            Evento evento = em.find(Evento.class, id);
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
