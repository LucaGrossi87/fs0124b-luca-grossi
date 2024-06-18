package it.epicode.valhallagaming.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@MappedSuperclass
@Data
public abstract class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private boolean available = true;

    @OneToMany(mappedBy = "station")
    private List<Booking> bookingList;

    public Station(boolean available, List<Booking> bookingList){
        this.available=available;
        this.bookingList=bookingList;
    }
}
