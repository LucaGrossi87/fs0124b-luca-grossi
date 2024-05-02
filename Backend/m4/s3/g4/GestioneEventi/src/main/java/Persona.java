import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@Entity
@Table (name="persona")
public class Persona {

    public enum Sesso {
        M,
        F
    }

    @Id
    @Column (name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persona_seq")
    @SequenceGenerator(name = "persona_seq", sequenceName = "persona_sequence", allocationSize = 1)
    private long id;

    @Column (name="nome")
    private String nome;

    @Column (name="cognome")
    private String cognome;

    @Column (name = "email")
    private String email;

    @Column (name = "dataNascita")
    private LocalDate dataNascita;

    @Column (name = "sesso")
    @Enumerated(EnumType.STRING)
    private Sesso sesso;

    @Column (name = "listaPartecipazioni")
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private List<Partecipazione> listaPartecipazioni = new ArrayList<>();

//    public Persona(String mario, String rossi, String mail, LocalDate localDate, Sesso m){}

    public Persona(String nome, String cognome, String email, LocalDate dataNascita, Sesso sesso) {
//        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataNascita = dataNascita;
        this.sesso = sesso;
//        this.listaPartecipazioni = listaPartecipazioni;
    }

    public long getId() {
        return id;
    }

    public List<Partecipazione> getListaPartecipazioni() {
        return listaPartecipazioni;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }
}
