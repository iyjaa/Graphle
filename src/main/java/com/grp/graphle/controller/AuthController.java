package com.grp.graphle.controller;

import com.grp.graphle.dto.RegisterRequest;
import com.grp.graphle.entity.User;
import com.grp.graphle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public User login(@RequestBody Map<String, String> body) {
        return userService.login(body.get("email"), body.get("password"));
    }
}