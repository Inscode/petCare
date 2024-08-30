package com.projects.petCare.factory;

import com.projects.petCare.model.Patient;
import com.projects.petCare.model.Users;
import com.projects.petCare.repository.PatientRepo;
import com.projects.petCare.request.RegistrationRequest;
import com.projects.petCare.service.users.UserAttibutesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class PatientFactory {
    private final PatientRepo patientRepo;
    private final UserAttibutesMapper userAttibutesMapper;

    public Users createPatient(RegistrationRequest request) {
        Patient patient = new Patient();
        userAttibutesMapper.setCommonAttributes(request, patient);
        return patientRepo.save(patient);
    }
}
