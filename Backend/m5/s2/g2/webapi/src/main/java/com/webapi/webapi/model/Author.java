package com.webapi.webapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDate;
    private String avatar;

    public Author (String firstName, String lastName, String email, LocalDate birthDate, String avatar){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.birthDate=birthDate;
        this.avatar=avatar;
    }
}
