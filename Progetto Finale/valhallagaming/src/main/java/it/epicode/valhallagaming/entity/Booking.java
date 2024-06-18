package it.epicode.valhallagaming.entity;

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
    private User user;

    @ManyToOne
    @JoinColumn(name = "station_id", nullable = false)
    private Station station;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private boolean confirmed=false;

    public Booking(User user, Station station, LocalDate date, boolean confirmed){
        this.user=user;
        this.station=station;
        this.date=date;
        this.confirmed=confirmed;
    }
}
