package it.epicode.valhallagaming.dto.boardDTO;

import it.epicode.valhallagaming.entity.Booking;
import lombok.Data;

import java.util.List;

@Data
public class BoardEditRequest {
    private boolean available;
    private List<Booking> bookingList;
    private int seatsTotal;
    private int seatsAvailable;
    private boolean open;
    private final String method = "edit";
}
