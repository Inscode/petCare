package com.projects.petCare.controller;

import com.projects.petCare.controller.utils.UrlMapping;
import com.projects.petCare.dto.EntityConvertor;
import com.projects.petCare.dto.UserDto;
import com.projects.petCare.exception.ApiResponse;
import com.projects.petCare.exception.ResourceNotFoundException;
import com.projects.petCare.model.Users;
import com.projects.petCare.request.RegistrationRequest;
import com.projects.petCare.request.UserUpdateRequest;
import com.projects.petCare.service.users.UsersService;
import com.sun.net.httpserver.Authenticator;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(UrlMapping.USERS)
@RequiredArgsConstructor
@RestController

public class UsersController {
    private final UsersService usersService;
    private final EntityConvertor<Users, UserDto> entityConvertor;

    @PostMapping(UrlMapping.REGISTER_USER)
    public ResponseEntity<UserDto> add(@RequestBody RegistrationRequest request) {
        Users theUser = usersService.register(request);
        UserDto createdUser = entityConvertor.mapEntityToDto(theUser, UserDto.class);
        return ResponseEntity.ok(createdUser);
    }

    @PutMapping(UrlMapping.UPDATE_USER)

    public ResponseEntity<UserDto> update(@PathVariable Long userId,@RequestBody UserUpdateRequest request){
        Users theUser = usersService.update(userId, request);
        UserDto updatedUser = entityConvertor.mapEntityToDto(theUser, UserDto.class);
        return ResponseEntity.ok(updatedUser);

    }


    @GetMapping(UrlMapping.GET_USER_BY_ID)

    public ResponseEntity<UserDto> findById(@PathVariable Long userId){

        Users user = usersService.findById(userId);
        UserDto theUser = entityConvertor.mapEntityToDto(user, UserDto.class);
        return ResponseEntity.ok().body(theUser);

    }

    @DeleteMapping(UrlMapping.DELETE_USER)

    public ResponseEntity<String> delete(@PathVariable Long userId){
        try{
            usersService.delete(userId);
            return ResponseEntity.status(HttpStatus.OK).body("user deleted successfully");
        }catch (ResourceNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping(UrlMapping.GET_ALL_USERS)

    public ResponseEntity<List<UserDto>> getAllUsers()
    {
        List<UserDto> users = usersService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

}
