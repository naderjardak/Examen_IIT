package io.microservice.userservice.Service;


import io.microservice.userservice.configuration.SessionService;
import io.microservice.userservice.repositories.RoleRepository;
import io.microservice.userservice.Service.interfaces.UserInterface;
import io.microservice.userservice.entities.Role;
import io.microservice.userservice.entities.User;
import io.microservice.userservice.repositories.UserrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;

@Service
public class UserService implements UserInterface {

    @Autowired
    SessionService sessionService;

    @Autowired
    UserrRepository userRepository;

    @Autowired
    RoleRepository roleRepository;


    PasswordEncoder passwordEncoder;

    @Autowired
    public UserService() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public void CreateForReset(User u) {
        u.setPassword(this.passwordEncoder.encode(u.getPassword()));
        userRepository.save(u);
    }

    @Override
    public User findByResetToken(String resetToken) {
        return userRepository.findByResetToken(resetToken);
    }

    @Override
    public User Create(User u,Long n) {
        if (validatePassword(u.getPassword()) && userRepository.findUserByEmail(u.getEmail())==null) {
            u.setPassword(this.passwordEncoder.encode(u.getPassword()));
            u.setRole(roleRepository.findById(n).get());
            return userRepository.save(u);
        }
        return new User();
    }

    @Override
    public void DeleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User update(User u) {
        return userRepository.save(u);
    }

    @Override
    public User GetById(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> GetAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void affectRoleAtUser(long idRole, long idUser) {
        Role r = roleRepository.findById(idRole).get();
        User u = userRepository.findById(idUser).get();
        u.setRole(r);
        userRepository.save(u);
    }

    public User findByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }


    public boolean validatePassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (isSpecialChar(c)) {
                hasSpecialChar = true;
            }
        }
        return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar;
    }

    private boolean isSpecialChar(char c) {
        // Replace this with your desired set of special characters
        String specialChars = "!@#$%^&*()_+-=[]{}|;':\"<>,.?/\\";
        return specialChars.indexOf(c) != -1;
    }

    @Override
    public List<Map<String, Integer>> statsByRole() {
        return userRepository.statsUsersByRole();
    }


    public List<Role> getAllRolesd() {
        return (List<Role>) roleRepository.findAll();
    }

    @Override
    public boolean sessionReteurn() {
        User user = sessionService.getUserBySession();
        return !user.equals(new User());
    }

    @Override
    public User updateUserByID(long id,User u) {
        User user1 = userRepository.findById(id).get();
        return userRepository.save(user1);
    }

    @Override
    public User userConnected()
    {
        return sessionService.getUserBySession();
    }

    private static final String FILE_DIRECTORY = "C:/Users/ADMIN/OneDrive/Bureau/TYM/TYM_B2C_Front/src/assets/uploads";
    @Override
    public void storeFile(MultipartFile file) throws IOException {
        Path filePath1 = Paths.get(FILE_DIRECTORY + "/" + file.getOriginalFilename());
        Files.copy(file.getInputStream(), filePath1, StandardCopyOption.REPLACE_EXISTING);
    }


}