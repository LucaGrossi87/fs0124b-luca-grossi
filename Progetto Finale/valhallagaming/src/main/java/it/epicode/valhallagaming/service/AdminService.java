package it.epicode.valhallagaming.service;

import it.epicode.valhallagaming.entity.Admin;
import it.epicode.valhallagaming.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> findAll(){
        return adminRepository.findAll();
    }

    public Optional<Admin> findById (Long id){
        return adminRepository.findById(id);
    }

    public Admin save (Admin admin){
        return adminRepository.save(admin);
    }

    public void deleteById(Long id){
        adminRepository.deleteById(id);
    }

    public Optional<Admin> findLoggedin(){
        return adminRepository.findByLoggedin(true);
    }

    public Optional<Admin> findByUserName(String username){
        return adminRepository.findByUserName(username);
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Admin registerAdmin(String firstName, String lastName, String userName, String email, String rawPassword) {
        String encodedPassword = passwordEncoder.encode(rawPassword);
        Admin admin = new Admin(firstName, lastName, userName, email, encodedPassword, false);
        return adminRepository.save(admin);
    }
}
