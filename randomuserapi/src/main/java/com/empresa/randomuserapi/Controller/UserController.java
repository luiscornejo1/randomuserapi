package com.empresa.randomuserapi.controller;

import com.empresa.randomuserapi.dto.UserDTO;
import com.empresa.randomuserapi.service.RandomUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final RandomUserService service;

    public UserController(RandomUserService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserDTO> getUsers() {
        return service.fetchUsers();
    }
}
