package com.sivapoc.elt.employeelt.service;

import com.sivapoc.elt.employeelt.dto.UserRequest;
import com.sivapoc.elt.employeelt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    User user = new User();

    public void register(UserRequest request) {
        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
    }
}
