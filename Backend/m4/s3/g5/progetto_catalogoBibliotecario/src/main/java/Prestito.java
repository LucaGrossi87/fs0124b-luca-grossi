import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class Prestito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Utente utente;

    @OneToOne
    private ElementoCatalogo elementoPrestato;

    private Date dataInizioPrestito;
    private Date dataRestituzionePrevista;
    private Date dataRestituzioneEffettiva;

    public Prestito() {}

    public Prestito(Utente utente, ElementoCatalogo elementoPrestato, Date dataInizioPrestito) {
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.dataInizioPrestito = dataInizioPrestito;

        this.dataRestituzionePrevista = new Date(dataInizioPrestito.getTime() + (30 * 24 * 60 * 60 * 1000));
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public ElementoCatalogo getElementoPrestato() {
        return elementoPrestato;
    }

    public void setElementoPrestato(ElementoCatalogo elementoPrestato) {
        this.elementoPrestato = elementoPrestato;
    }

    public Date getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(Date dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public Date getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public Date getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(Date dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }
}
