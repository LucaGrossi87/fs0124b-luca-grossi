package it.epicode.valhallagaming.dto.adminDTO;

import lombok.Data;

@Data
public class AdminEditRequest {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private boolean loggedin;
    private final String method = "edit";
}
