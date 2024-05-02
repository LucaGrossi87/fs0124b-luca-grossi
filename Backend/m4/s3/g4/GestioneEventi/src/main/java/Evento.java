import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table (name="evento")
public class Evento {

    public enum TipoEvento {
        PUBBLICO,
        PRIVATO
    }

    @Id
    @Column (name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evento_seq")
    @SequenceGenerator(name = "evento_seq", sequenceName = "evento_sequence", allocationSize = 1)
    private long id;

    @Column (name="titolo")
    private String titolo;

    @Column (name = "dataEvento")
    private LocalDate dataEvento;

    @Column (name = "descrizione")
    private String descrizione;

    @Column (name = "tipoEvento")
    private TipoEvento tipoEvento;

    @Column (name = "maxPartecipanti")
    private int maxPartecipanti;

//    public Evento(String partitaDiCalcio, LocalDate localDate, String derby, TipoEvento pubblico, int i){}

    public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int maxPartecipanti) {
//        this.id = id;
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.maxPartecipanti = maxPartecipanti;
    }

    public long getId() {
        return id;
    }

    public int getMaxPartecipanti() {
        return maxPartecipanti;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getTitolo() {
        return titolo;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }
}
