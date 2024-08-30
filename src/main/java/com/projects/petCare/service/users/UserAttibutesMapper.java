package com.projects.petCare.service.users;

import com.projects.petCare.model.Users;
import com.projects.petCare.request.RegistrationRequest;
import org.springframework.stereotype.Service;

@Service

public class UserAttibutesMapper {
    public void setCommonAttributes(RegistrationRequest source, Users target){
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setGender(source.getGender());
        target.setPhoneNumber(source.getPhoneNumber());
        target.setEmail(source.getEmail());
        target.setPassword(source.getPassword());
        target.setUserType(source.getUserType());
        target.setEnabled(source.isEnabled());

    }

}
