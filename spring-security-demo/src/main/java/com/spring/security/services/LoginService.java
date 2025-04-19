package com.spring.security.services;

import com.spring.security.entities.User;
import com.spring.security.model.LoginRequest;
import com.spring.security.model.LoginResponse;
import com.spring.security.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

private final UserRepository userRepository;

private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;
    public LoginService(UserRepository userRepository, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public LoginResponse login(LoginRequest loginRequest){
        LoginResponse response = new LoginResponse();
        Authentication auth =  authenticationManager.
                authenticate(new UsernamePasswordAuthenticationToken
                        (loginRequest.getUserName(), loginRequest.getUserPassword()));

        User getUserDetails = userRepository.
              findByUserName(loginRequest.getUserName()).orElseThrow(() ->
                      new UsernameNotFoundException("User not found with username: john"));

        String jwtToken = jwtService.generateToken(getUserDetails);
        response.setAccessToken(jwtToken);
       return response;
    }

}
