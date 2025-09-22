package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // 1️⃣ Home route → http://localhost:8085/
    @GetMapping("/")
    public String home() {
        return "Backend is running 🚀";
    }

    // 2️⃣ Signup endpoint → http://localhost:8085/api/user/signup
    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        return userService.signup(user);
    }

    // 3️⃣ Login endpoint → http://localhost:8085/user/login
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        return userService.login(username, password);
    }
}
