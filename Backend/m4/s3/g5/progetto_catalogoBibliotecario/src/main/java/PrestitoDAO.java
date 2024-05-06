import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class PrestitoDAO {

    private EntityManager entityManager;

    public PrestitoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void registraPrestito(Prestito prestito) {
        entityManager.getTransaction().begin();
        entityManager.persist(prestito);
        entityManager.getTransaction().commit();
    }

    public void registraRestituzione(Prestito prestito) {
        entityManager.getTransaction().begin();
        prestito.setDataRestituzioneEffettiva(new Date());
        entityManager.getTransaction().commit();
    }

    public List<Prestito> cercaPrestitiPerNumeroTessera(String numeroTessera) {
        Query query = entityManager.createQuery("SELECT p FROM Prestito p WHERE p.utente.numeroTessera = :numeroTessera");
        query.setParameter("numeroTessera", numeroTessera);
        return query.getResultList();
    }

    public List<Prestito> cercaPrestitiScadutiNonRestituiti() {
        Query query = entityManager.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzionePrevista < CURRENT_DATE AND p.dataRestituzioneEffettiva IS NULL");
        return query.getResultList();
    }

}
