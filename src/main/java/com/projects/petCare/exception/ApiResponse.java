package com.projects.petCare.exception;

import com.projects.petCare.dto.UserDto;
import lombok.Data;

@Data
public class ApiResponse {
    private String message;
    private UserDto data;

    // Constructor for success responses with UserDto data
    public ApiResponse(String message, UserDto data) {
        this.message = message;
        this.data = data;
    }

    // Constructor for error responses without data
    public ApiResponse(String message) {
        this.message = message;
        this.data = null;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserDto getData() {
        return data;
    }

    public void setData(UserDto data) {
        this.data = data;
    }
}
