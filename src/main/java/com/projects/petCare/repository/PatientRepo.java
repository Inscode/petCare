package com.projects.petCare.repository;

import com.projects.petCare.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Long> {
}
