package it.epicode.valhallagaming.dto.adminDTO;

import lombok.Data;

@Data
public class AuthenticationResponse {
    private final String jwt;
}