package com.projects.petCare.repository;

import com.projects.petCare.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users, Long> {
    boolean existsByEmail(String email);
}
