package com.webapi.webapi.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthDTO {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Mandatory")
    @Size(max = 20, message = "Max length 20 characters")
    private String firstName;

    @NotBlank(message = "Mandatory")
    @Size(max = 20, message = "Max length 20 characters")
    private String lastName;

    @NotBlank(message = "Mandatory")
    @Email(message = "Insert valid email")
    private String email;

    @NotNull(message = "Mandatory")
    @Past(message = "Birthdate can be future")
    private LocalDate birthDate;

    @Size(max = 255, message = "Url max length 255 characters")
    @URL
    private String avatar;

    public AuthDTO (String firstName, String lastName, String email, LocalDate birthDate, String avatar){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.birthDate=birthDate;
        this.avatar=avatar;
    }

}
