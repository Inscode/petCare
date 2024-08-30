package com.projects.petCare.service.users;

import com.projects.petCare.dto.EntityConvertor;
import com.projects.petCare.dto.UserDto;
import com.projects.petCare.exception.ResourceNotFoundException;
import com.projects.petCare.factory.UserFactory;
import com.projects.petCare.model.Users;
import com.projects.petCare.repository.UsersRepo;
import com.projects.petCare.request.RegistrationRequest;
import com.projects.petCare.request.UserUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class UsersService implements IUserService {
    private final UsersRepo usersRepo;
    private final UserFactory userFactory;
    private final EntityConvertor<Users, UserDto> entityConvertor;

    @Override
    public Users register(RegistrationRequest request) {
        return userFactory.createUser(request);
    }

    @Override
    public Users update(Long userId, UserUpdateRequest request){
        Users user = findById(userId);
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setGender(request.getGender());
        user.setSpecialization(request.getSpecialization());
        return usersRepo.save(user);
    }

    @Override
    public Users findById(Long userId){
        return usersRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user Not found"));

    }

    @Override
    public void delete(Long userId){
        usersRepo.findById(userId)
                .ifPresentOrElse(usersRepo::delete, () -> {
                    throw new ResourceNotFoundException("USER NOT FOUND");
                });
    }

    @Override
    public List<UserDto> getAllUsers(){
        List<Users> users = usersRepo.findAll();
        return users.stream()
                .map(user -> entityConvertor.mapEntityToDto(user, UserDto.class))
                .collect(Collectors.toList());
    }
}
