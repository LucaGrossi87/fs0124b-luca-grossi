import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "partecipazione")
public class Partecipazione {

    public enum Stato {
        CONFERMATA,
        DA_CONFERMARE
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "partecipazione_seq")
    @SequenceGenerator(name = "partecipazione_seq", sequenceName = "partecipazione_sequence", allocationSize = 1)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "id_evento")
    private Evento evento;

    @Column(name = "stato")
    @Enumerated(EnumType.STRING)
    private Stato stato;

//    public Partecipazione() {
//    }

    public Partecipazione(Persona persona, Evento evento, Stato stato) {
//        this.id = id;
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }

    public long getId() {
        return id;
    }

    public Persona getPersona() {
        return persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public Stato getStato() {
        return stato;
    }
}
