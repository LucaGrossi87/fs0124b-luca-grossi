package it.epicode.valhallagaming.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "station_id", nullable = false)
    private Station station;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private boolean open;

    @Column(nullable = false)
    private boolean confirmed=false;

    @Column(nullable = false)
    private int guests;

    @Column(nullable = false)
    private int seatsAvailable;

    public Booking(User user, Station station, LocalDate date, boolean open, boolean confirmed, int guests, int seatsAvailable){
        this.user=user;
        this.station=station;
        this.date=date;
        this.open=open;
        this.confirmed=confirmed;
        this.guests=guests;
        this.seatsAvailable=seatsAvailable;
    }
}
