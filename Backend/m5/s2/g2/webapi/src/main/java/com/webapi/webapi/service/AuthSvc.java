package com.webapi.webapi.service;

import com.webapi.webapi.model.Author;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AuthSvc {

    public Author newAuth(Long id, String firstName, String lastName, String email, LocalDate birthDate, String avatar) {
        Author nauth = new Author();
        nauth.setId(id);
        nauth.setFirstName(firstName);
        nauth.setLastName(lastName);
        nauth.setEmail(email);
        nauth.setBirthDate(birthDate);
        nauth.setAvatar(avatar);
        return nauth;
    }

}
