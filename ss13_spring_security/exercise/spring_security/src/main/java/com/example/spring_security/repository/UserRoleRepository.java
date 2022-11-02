package com.example.spring_security.repository;

import com.example.spring_security.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUserName(String userName);
}
