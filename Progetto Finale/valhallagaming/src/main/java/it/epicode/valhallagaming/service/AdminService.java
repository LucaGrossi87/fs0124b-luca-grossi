package it.epicode.valhallagaming.service;

import it.epicode.valhallagaming.entity.Admin;
import it.epicode.valhallagaming.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
