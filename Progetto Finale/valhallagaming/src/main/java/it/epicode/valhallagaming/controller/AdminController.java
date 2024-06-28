package it.epicode.valhallagaming.controller;

import it.epicode.valhallagaming.dto.adminDTO.AdminCreateRequest;
import it.epicode.valhallagaming.dto.adminDTO.AdminDeleteResponse;
import it.epicode.valhallagaming.dto.adminDTO.AdminEditRequest;
import it.epicode.valhallagaming.dto.adminDTO.AdminResponse;
import it.epicode.valhallagaming.entity.Admin;
import it.epicode.valhallagaming.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public List<AdminResponse> getAllAdmins() {
        return adminService.findAll().stream()
                .map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping ("/{id}")
    public AdminResponse getAdminById(@PathVariable Long id){
        Optional<Admin> admin = adminService.findById(id);
        return admin.map(this::convertToDTO).orElse(null);
    }

    @PostMapping
    public AdminResponse createAdmin (@RequestBody AdminCreateRequest adminCreateRequest){
        Admin admin = convertToEntity(adminCreateRequest);
        Admin savedAdmin = adminService.registerAdmin(admin);
        return convertToDTO(savedAdmin);
    }

    @PutMapping ("/{id}")
    public AdminResponse editAdmin (@PathVariable Long id, @RequestBody AdminEditRequest adminEditRequest){
        Admin admin = convertToEntity(adminEditRequest);
        admin.setId(id);
        Admin updatedAdmin = adminService.registerAdmin(admin);
        return convertToDTO(updatedAdmin);
    }

    @DeleteMapping ("/{id}")
    public AdminDeleteResponse deleteAdmin (@PathVariable Long id){
        adminService.deleteById(id);
        AdminDeleteResponse response = new AdminDeleteResponse();
        response.setId(id);
        response.setMessage("Admin eliminato");
        return response;
    }

    private AdminResponse convertToDTO (Admin admin){
        AdminResponse dto = new AdminResponse();
        dto.setId(admin.getId());
        dto.setFirstName(admin.getFirstName());
        dto.setLastName(admin.getLastName());
        dto.setUserName(admin.getUserName());
        dto.setEmail(admin.getEmail());
        dto.setLoggedin(admin.isLoggedin());
        return dto;
    }

    private Admin convertToEntity (AdminCreateRequest dto){
        return new Admin(dto.getFirstName(), dto.getLastName(), dto.getUserName(), dto.getEmail(), dto.getPassword(), dto.isLoggedin());
    }

    private Admin convertToEntity (AdminEditRequest dto){
        return new Admin(dto.getFirstName(), dto.getLastName(), dto.getUserName(), dto.getEmail(), dto.getPassword(), dto.isLoggedin());
    }
}
