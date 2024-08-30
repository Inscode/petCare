package com.projects.petCare.factory;

import com.projects.petCare.model.Users;
import com.projects.petCare.model.Veterinarian;
import com.projects.petCare.repository.VeterinarianRepo;
import com.projects.petCare.request.RegistrationRequest;
import com.projects.petCare.service.users.UserAttibutesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class VeterinarianFactory {
    private final VeterinarianRepo veterinarianRepo;
    private final UserAttibutesMapper userAttibutesMapper;

    public Users createVeterinarian(RegistrationRequest request) {
        Veterinarian veterinarian = new Veterinarian();
        userAttibutesMapper.setCommonAttributes(request, veterinarian);
        veterinarian.setSpecialization(request.getSpecialization());
        return veterinarianRepo.save(veterinarian);
    }
}
