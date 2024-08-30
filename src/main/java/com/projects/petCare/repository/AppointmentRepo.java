package com.projects.petCare.repository;

import com.projects.petCare.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
    Appointment findByAppointmentNo(String appointmentNo);
}
