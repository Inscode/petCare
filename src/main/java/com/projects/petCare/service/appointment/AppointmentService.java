package com.projects.petCare.service.appointment;

import com.projects.petCare.enums.AppointmentStatus;
import com.projects.petCare.exception.ResourceNotFoundException;
import com.projects.petCare.model.Appointment;
import com.projects.petCare.model.Users;
import com.projects.petCare.repository.AppointmentRepo;
import com.projects.petCare.repository.UsersRepo;
import com.projects.petCare.request.AppointmentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class AppointmentService implements IAppointmentService{

    private final AppointmentRepo appointmentRepo;
    private final UsersRepo usersRepo;

    @Override
    public Appointment createAppointment(Appointment appointment, Long senderId, Long recipientId) {
        Optional<Users> sender = usersRepo.findById(senderId);
        Optional<Users> recipient = usersRepo.findById(recipientId);

        if(sender.isPresent() && recipient.isPresent()){
            appointment.setPatient(sender.get());
            appointment.setVeterinarian(recipient.get());
            appointment.setAppointmentNo();
            appointment.setStatus(AppointmentStatus.PENDING);
            return appointmentRepo.save(appointment);
        }

        throw new ResourceNotFoundException("sender or recipient not found");
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepo.findAll();
    }

    @Override
    public Appointment updateAppointment(Long id, AppointmentRequest request) {
        return null;
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepo.findById(id)
                .ifPresent(appointmentRepo::delete);
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("appointment not found"));
    }

    @Override
    public Appointment getAppointmentByNo(String appointmentNo) {
        return appointmentRepo.findByAppointmentNo(appointmentNo);
    }
}
