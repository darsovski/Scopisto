package com.petshop.web.rest;


import com.petshop.scopisto.model.Dto.UserDto;
import com.petshop.scopisto.model.User;
import com.petshop.scopisto.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/users")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {this.userService=userService; }

    @GetMapping
    private List<User> findAll() { return this.userService.findAll(); };

    @PostMapping("/add")
    public ResponseEntity<User> save(@RequestBody UserDto userDto) {

        return this.userService.save(userDto)
                .map(user -> ResponseEntity.ok().body(user))
                .orElseGet( () -> ResponseEntity.badRequest().build());
    }

}
