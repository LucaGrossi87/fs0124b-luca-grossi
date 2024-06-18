package it.epicode.valhallagaming.dto.lanDTO;

import lombok.Data;

@Data
public class LanDeleteResponse {
    private Long id;
    private String message;
    private final String method = "delete";
}
