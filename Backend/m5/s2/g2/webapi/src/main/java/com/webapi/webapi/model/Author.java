package com.webapi.webapi.model;

import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Author {

//    @Id
//    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDate;
    private String avatar;

    public Author (Long id, String firstName, String lastName, String email, LocalDate birthDate, String avatar){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.birthDate=birthDate;
        this.avatar=avatar;
    }
}
