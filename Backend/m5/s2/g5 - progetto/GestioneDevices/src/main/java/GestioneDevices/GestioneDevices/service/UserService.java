package GestioneDevices.GestioneDevices.service;

import GestioneDevices.GestioneDevices.model.User;
import GestioneDevices.GestioneDevices.auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean existsByUsername(String username) {
        return userRepository.findByUsername(username) != null;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
