package com.spring.security.mapper;

import com.spring.security.entities.User;
import com.spring.security.model.CreateUserRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SecurityMapper {

    public static User createUserRequestMapper(CreateUserRequest createUserRequest,  PasswordEncoder passwordEncoder){
        User user = new User();
        user.setUserName(createUserRequest.getUserName());
        user.setUserPassword(passwordEncoder.encode(createUserRequest.getUserPassword()));
        user.setUserEmail(createUserRequest.getUserEmail());
        return user;
    }
}
