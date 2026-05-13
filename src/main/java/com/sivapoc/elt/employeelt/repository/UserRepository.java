package com.sivapoc.elt.employeelt.repository;

import com.sivapoc.elt.employeelt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUsername(String username);
}