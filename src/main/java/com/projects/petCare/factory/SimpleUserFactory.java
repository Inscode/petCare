package com.projects.petCare.factory;

import com.projects.petCare.exception.UserAlreadyExistsException;
import com.projects.petCare.model.Users;
import com.projects.petCare.repository.UsersRepo;
import com.projects.petCare.request.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component

public class SimpleUserFactory implements UserFactory{
    private final UsersRepo usersRepo;
    private final VeterinarianFactory veterinarianFactory;
    private final AdminFactory adminFactory;
    private final PatientFactory patientFactory;
    @Override
    public Users createUser(RegistrationRequest registrationRequest) {
        if(usersRepo.existsByEmail(registrationRequest.getEmail())){
            throw new UserAlreadyExistsException("oops" + registrationRequest.getEmail() + "already exists");
        }

        switch (registrationRequest.getUserType()){
            case "VET" -> {return veterinarianFactory.createVeterinarian(registrationRequest);}

            case "PATIENT" -> {return patientFactory.createPatient(registrationRequest);}

            case "ADMIN" -> {return adminFactory.createAdmin(registrationRequest);}

            default -> {
                return null;
            }
        }
    }
}
