package com.sivapoc.elt.employeelt.service;

import com.sivapoc.elt.employeelt.dto.LoginRequest;
import com.sivapoc.elt.employeelt.dto.RegisterRequest;
import com.sivapoc.elt.employeelt.entity.User;
import com.sivapoc.elt.employeelt.repository.UserRepository;
import com.sivapoc.elt.employeelt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    // ✅ REGISTER
    public String register(RegisterRequest request) {

        User user = new User();
        user.setUserId(UUID.randomUUID().toString());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        user.setRoleId("2"); // USER
        user.setCreatedAt(LocalDateTime.now());

        userRepository.save(user);

        return "User registered successfully";
    }

    // ✅ LOGIN
    public String login(LoginRequest request) {
        System.out.println("service:" + request.getUsername() + "---" + request.getPassword());
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        System.out.println("INPUT PASSWORD = [" + request.getPassword() + "]");
        System.out.println("DB HASH = [" + user.getPasswordHash() + "]");

        boolean match = passwordEncoder.matches(request.getPassword(), user.getPasswordHash());
        System.out.println("MATCH RESULT = " + match);

        if (!match) {
            throw new RuntimeException("Invalid credentials");
        }


        return "Login success";
    }
}
