package com.projects.petCare.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String s){
        super(s);
    }
}
