package com.projects.petCare.service.appointment;

import com.projects.petCare.model.Appointment;
import com.projects.petCare.request.AppointmentRequest;

import java.util.List;

public interface IAppointmentService {
    Appointment createAppointment(Appointment appointment, Long sender, Long recipient);
    List<Appointment> getAllAppointments();
    Appointment updateAppointment(Long id, AppointmentRequest request);
    void deleteAppointment(Long id);
    Appointment getAppointmentById(Long id);
    Appointment getAppointmentByNo(String appointmentNo);

}
