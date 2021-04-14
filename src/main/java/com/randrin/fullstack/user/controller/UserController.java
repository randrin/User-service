package com.randrin.fullstack.user.controller;

import com.randrin.fullstack.user.entity.User;
import com.randrin.fullstack.user.request.ResponseTemplate;
import com.randrin.fullstack.user.service.UserService;
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
