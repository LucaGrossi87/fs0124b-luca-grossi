package it.epicode.valhallagaming.controller;

import it.epicode.valhallagaming.dto.adminDTO.AuthenticationRequest;
import it.epicode.valhallagaming.dto.adminDTO.AuthenticationResponse;
import it.epicode.valhallagaming.entity.Admin;
import it.epicode.valhallagaming.repository.AdminRepository;
import it.epicode.valhallagaming.service.AdminDetailsService;
import it.epicode.valhallagaming.service.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AdminDetailsService adminDetailsService;

    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (AuthenticationException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = adminDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        System.out.println(userDetails.getUsername()+userDetails.getPassword());
        final String jwt = jwtUtil.generateToken(userDetails);

        Admin admin = adminRepository.findByUserName(authenticationRequest.getUsername())
                .orElseThrow(() -> new Exception("Admin not found"));
        admin.setLoggedin(true);
        System.out.println(admin.getUserName());
        adminRepository.save(admin);

        System.out.println(ResponseEntity.ok(new AuthenticationResponse(jwt, admin)));

        return ResponseEntity.ok(new AuthenticationResponse(jwt, admin));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            String username = ((UserDetails) authentication.getPrincipal()).getUsername();

            Admin admin = adminRepository.findByUserName(username)
                    .orElseThrow(() -> new RuntimeException("Admin not found"));
            admin.setLoggedin(false);
            adminRepository.save(admin);

            SecurityContextHolder.clearContext();
        }
        return ResponseEntity.ok().build();
    }
}
