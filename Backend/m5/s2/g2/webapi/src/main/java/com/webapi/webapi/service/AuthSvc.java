package com.webapi.webapi.service;

import com.webapi.webapi.dto.AuthDTO;
import com.webapi.webapi.model.Author;
import com.webapi.webapi.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AuthSvc {

    @Autowired
    private AuthorRepository authRepo;

    public Author newAuth(String firstName, String lastName, String email, LocalDate birthDate, String avatar) {
        Author nauth = new Author(firstName, lastName, email, birthDate, avatar);
        return authRepo.save(nauth);
    }

    public Author getById (Long id){
        return authRepo.findAuthorById(id);
    }

    public List<Author> getAllAuths(){
        return authRepo.findAll();
    }

    public void deleteAuth(Long id){
        authRepo.deleteById(id);
    }

    public Author createAuth(AuthDTO authDTO) {
        Author newAuth = new Author();
        newAuth.setFirstName(authDTO.getFirstName());
        newAuth.setLastName(authDTO.getLastName());
        newAuth.setEmail(authDTO.getEmail());
        newAuth.setBirthDate(authDTO.getBirthDate());
        newAuth.setAvatar(authDTO.getAvatar());

        return authRepo.save(newAuth);
    }

    public Author updateAuth(Author result, AuthDTO edAuthDTO) {
        result.setFirstName(edAuthDTO.getFirstName());
        result.setLastName(edAuthDTO.getLastName());
        result.setEmail(edAuthDTO.getEmail());
        result.setBirthDate(edAuthDTO.getBirthDate());
        result.setAvatar(edAuthDTO.getAvatar());
        return authRepo.save(result);
    }

}
