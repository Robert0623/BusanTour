package com.myportfolio.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @GetMapping("/add")
    public String register() {
        return "registerForm";
    }
    @PostMapping("/add")
    public String info() {
        return "registerInfo";
    }
}
