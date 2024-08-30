package com.projects.petCare.repository;

import com.projects.petCare.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin, Long> {
}
