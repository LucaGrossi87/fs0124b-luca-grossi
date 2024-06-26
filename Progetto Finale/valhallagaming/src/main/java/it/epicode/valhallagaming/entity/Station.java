package it.epicode.valhallagaming.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "stations")
@Data
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private boolean available = true;

    @OneToMany(mappedBy = "station")
    private List<Booking> bookingList;

    @Column(nullable = false)
    private StationType stationType;


    @Column(nullable = false)
    private int seatsTotal;

    public Station(List<Booking> bookingList, StationType stationType, int seatsTotal){
        this.available=available;
        this.bookingList=bookingList;
        this.stationType=stationType;
        this.seatsTotal=seatsTotal;
    }
}
