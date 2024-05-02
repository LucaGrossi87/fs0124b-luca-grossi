import javax.persistence.*;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_seq")
    @SequenceGenerator(name = "location_seq", sequenceName = "location_sequence", allocationSize = 1)
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "citta")
    private String citta;

//    public Location(String stadioOlimpico, String roma) {
//    }

    public Location(String nome, String citta) {
//        this.id = id;
        this.nome = nome;
        this.citta = citta;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCitta() {
        return citta;
    }
}
