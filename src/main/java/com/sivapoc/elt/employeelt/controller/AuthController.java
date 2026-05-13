package com.sivapoc.elt.employeelt.controller;

import com.sivapoc.elt.employeelt.dto.LoginRequest;
import com.sivapoc.elt.employeelt.dto.RegisterRequest;
import com.sivapoc.elt.employeelt.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/employee")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/api/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
       System.out.println( request.getUsername());
        System.out.println( request.getPassword());
        String token = authService.login(request);
        return ResponseEntity.ok(Map.of("token", token));
    }
}