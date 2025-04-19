package com.spring.security.controller.login;

import com.spring.security.model.CreateUserRequest;
import com.spring.security.model.LoginRequest;
import com.spring.security.model.LoginResponse;
import com.spring.security.services.LoginService;
import com.spring.security.services.UserServiceForCrudOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final AuthenticationManager authenticationManager;

    private final LoginService loginService;

    public LoginController( AuthenticationManager authenticationManager, LoginService loginService) {

        this.authenticationManager = authenticationManager;
        this.loginService = loginService;
    }


    @PostMapping("/auth")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        LoginResponse loginResponse = new LoginResponse();
        loginResponse = loginService.login(loginRequest);
        return new ResponseEntity<>(loginResponse, HttpStatus.ACCEPTED);
    }


}
