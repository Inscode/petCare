package com.projects.petCare.factory;

import com.projects.petCare.model.Admin;
import com.projects.petCare.model.Users;
import com.projects.petCare.repository.AdminRepo;
import com.projects.petCare.request.RegistrationRequest;
import com.projects.petCare.service.users.UserAttibutesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AdminFactory {
    private final AdminRepo adminRepo;
    private final UserAttibutesMapper userAttibutesMapper;

    public Admin createAdmin(RegistrationRequest request) {
        Admin admin = new Admin();
        userAttibutesMapper.setCommonAttributes(request, admin);
        return adminRepo.save(admin);
    }
}
