package com.projects.petCare.factory;

import com.projects.petCare.model.Users;
import com.projects.petCare.request.RegistrationRequest;

public interface UserFactory {
    public Users createUser(RegistrationRequest registrationRequest);
}
