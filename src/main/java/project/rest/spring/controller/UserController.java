package project.rest.spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.rest.spring.service.UserService;

import javax.persistence.Entity;

@RestController
@CrossOrigin
@RequestMapping("/usuario")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;

    }

//
}
