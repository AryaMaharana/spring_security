package com.spring.security.controller.user;

import com.spring.security.model.CreateUserRequest;
import com.spring.security.services.UserServiceForCrudOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UsersController {


    private final UserServiceForCrudOperation userServiceForCrudOperation;

    private final AuthenticationManager authenticationManager;

    public UsersController(UserServiceForCrudOperation userServiceForCrudOperation, AuthenticationManager authenticationManager) {
        this.userServiceForCrudOperation = userServiceForCrudOperation;
        this.authenticationManager = authenticationManager;
    }


    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequest createUserRequest){
        userServiceForCrudOperation.createLoginUser(createUserRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
