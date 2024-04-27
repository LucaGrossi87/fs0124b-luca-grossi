import java.io.Serializable;
import java.util.Objects;

public class Rivista extends ElementoCatalogo implements Serializable {
    public enum Periodicita {
        SETTIMANALE,
        MENSILE,
        SEMESTRALE
    }

    private Periodicita periodicita;

    public Rivista(String isbn, String titolo, int anno, int pagine, Periodicita periodicita) {
        super(isbn, titolo, anno, pagine);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rivista)) return false;
        if (!super.equals(o)) return false;
        Rivista rivista = (Rivista) o;
        return periodicita == rivista.periodicita;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), periodicita);
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicita=" + periodicita +
                ", " + super.toString() +
                '}';
    }
}
