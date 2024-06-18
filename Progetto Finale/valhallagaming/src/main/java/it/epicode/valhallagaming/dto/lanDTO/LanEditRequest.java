package it.epicode.valhallagaming.dto.lanDTO;

import it.epicode.valhallagaming.entity.Booking;
import lombok.Data;

import java.util.List;

@Data
public class LanEditRequest {
    private boolean available;
    private List<Booking> bookingList;
    private final String method = "edit";
}
