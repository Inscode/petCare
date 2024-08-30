package com.projects.petCare.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private String email;
    private String userType;
    private boolean isEnabled;
    private String specialization;
}
