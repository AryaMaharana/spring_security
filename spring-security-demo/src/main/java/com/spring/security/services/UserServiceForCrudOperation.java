package com.spring.security.services;

import com.spring.security.entities.User;
import com.spring.security.mapper.SecurityMapper;
import com.spring.security.model.CreateUserRequest;
import com.spring.security.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceForCrudOperation {
    private final UserRepository  userRepository;
    private final SecurityMapper securityMapper;

    private final PasswordEncoder passwordEncoder;
    public UserServiceForCrudOperation(UserRepository userRepository, SecurityMapper securityMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.securityMapper = securityMapper;
        this.passwordEncoder = passwordEncoder;
    }


    public void createLoginUser(CreateUserRequest createUserRequest){
        try {
            userRepository.save(securityMapper.createUserRequestMapper(createUserRequest, passwordEncoder));
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
