package org.example.app.controller;

import org.example.app.entity.User;
import org.example.app.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
    private final UserService userService;

    public AuthController(UserService service) {
        this.userService = service;
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        System.out.println("Пользователь зарегистрирован");
        userService.register(user);
        return "redirect:/login";
    }

}
