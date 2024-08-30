package com.projects.petCare.service.users;

import com.projects.petCare.dto.UserDto;
import com.projects.petCare.model.Users;
import com.projects.petCare.request.RegistrationRequest;
import com.projects.petCare.request.UserUpdateRequest;

import java.util.List;

public interface IUserService {
    Users register(RegistrationRequest request);

    Users update (Long userId, UserUpdateRequest request);

    Users findById(Long userId);

    void delete(Long userId);

    List<UserDto> getAllUsers();
}

