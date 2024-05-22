package com.webapi.webapi.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthDTO {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDate;
    private String avatar;

    public AuthDTO (String firstName, String lastName, String email, LocalDate birthDate, String avatar){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.birthDate=birthDate;
        this.avatar=avatar;
    }

}
