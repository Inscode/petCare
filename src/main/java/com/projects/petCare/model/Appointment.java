package com.projects.petCare.model;

import com.projects.petCare.enums.AppointmentStatus;
import com.projects.petCare.service.appointment.AppointmentService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.prefs.PreferenceChangeEvent;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reason;
    private LocalDate date;
    private LocalTime time;
    private String appointmentNo;
    private LocalDate createdAt;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    @JoinColumn(name = "sender")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users patient;

    @JoinColumn(name = "recipient")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users veterinarian;

    public void addPatient(Users sender){
        this.setPatient(sender);

        if(sender.getAppointments() == null){
            sender.setAppointments(new ArrayList<>());
        }
        sender.getAppointments().add(this);
    }

    public void addVeterinarian(Users recipient){
        this.setVeterinarian(recipient);

        if(recipient.getAppointments() == null){
            recipient.setAppointments(new ArrayList<>());
        }
        recipient.getAppointments().add(this);
    }

    public void setAppointmentNo(){
        this.appointmentNo = String.valueOf(new Random().nextLong()).substring(1,11);
    }

}
