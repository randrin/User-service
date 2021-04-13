package com.randrin.fullstack.userservice.controller;

import com.randrin.fullstack.userservice.entity.User;
import com.randrin.fullstack.userservice.request.ResponseTemplate;
import com.randrin.fullstack.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{userId}")
    public ResponseTemplate getUserWithDepartment(@PathVariable Long userId) {
        return userService.getUserWithDepartment(userId);
    }
}
