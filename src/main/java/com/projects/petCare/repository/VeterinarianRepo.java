package com.projects.petCare.repository;

import com.projects.petCare.model.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarianRepo extends JpaRepository<Veterinarian, Long> {
}
