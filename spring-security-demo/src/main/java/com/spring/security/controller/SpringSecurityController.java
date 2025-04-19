package com.spring.security.controller;


import com.spring.security.model.CreateUserRequest;
import com.spring.security.model.LoginRequest;
import com.spring.security.model.LoginResponse;
import com.spring.security.services.LoginService;
import com.spring.security.services.UserServiceForCrudOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class SpringSecurityController {

    private final UserServiceForCrudOperation userServiceForCrudOperation;

    private final AuthenticationManager authenticationManager;

    private final LoginService loginService;

    public SpringSecurityController(UserServiceForCrudOperation userServiceForCrudOperation, AuthenticationManager authenticationManager, LoginService loginService) {
        this.userServiceForCrudOperation = userServiceForCrudOperation;
        this.authenticationManager = authenticationManager;
        this.loginService = loginService;
    }


    @PostMapping("/auth/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        LoginResponse loginResponse = new LoginResponse();
        loginResponse = loginService.login(loginRequest);
        return new ResponseEntity<>(loginResponse, HttpStatus.ACCEPTED);
    }

    @PostMapping("/auth/create")
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequest createUserRequest){
        userServiceForCrudOperation.createLoginUser(createUserRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
