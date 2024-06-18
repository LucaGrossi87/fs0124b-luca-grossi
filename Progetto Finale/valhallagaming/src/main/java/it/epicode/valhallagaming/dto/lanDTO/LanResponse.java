package it.epicode.valhallagaming.dto.lanDTO;

import it.epicode.valhallagaming.entity.Booking;
import lombok.Data;

import java.util.List;

@Data
public class LanResponse {
    private Long id;
    private boolean available;
    private List<Booking> bookingList;
}
