package it.epicode.valhallagaming.dto.bookingDTO;

import it.epicode.valhallagaming.entity.Station;
import it.epicode.valhallagaming.entity.User;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingEditRequest {
    private User user;
    private Station station;
    private LocalDate date;
    private boolean open;
    private boolean confirmed;
    private int guests;
    private int seatsAvailable;
    private final String method = "edit";

    public BookingEditRequest(User user, Station station, LocalDate date, boolean open, boolean confirmed, int guests, int seatsAvailable) {
        this.user = user;
        this.station = station;
        this.date = date;
        this.open = open;
        this.confirmed = confirmed;
        this.guests = guests;
        this.seatsAvailable = seatsAvailable;
    }
}
