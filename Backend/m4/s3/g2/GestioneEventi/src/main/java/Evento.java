import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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

    public Evento(){}

    public Evento (long id, String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int maxPartecipanti){
        this.id=id;
        this.titolo=titolo;
        this.dataEvento=dataEvento;
        this.descrizione=descrizione;
        this.tipoEvento=tipoEvento;
        this.maxPartecipanti=maxPartecipanti;
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
