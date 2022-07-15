package com.myportfolio.web.controller;

import com.myportfolio.web.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URLEncoder;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @GetMapping("/add")
    public String register() {
        return "registerForm";
    }
    @PostMapping("/add")
    public String save(User user, Model m) throws Exception {
        //1. 유효성 검사
        if(!isValid(user)) {
            String msg = URLEncoder.encode("id를 잘못 입력하셨습니다.", "utf-8");
            m.addAttribute("msg", msg);
//            return "redirect:/register/add";
            return "forward:/register/add";
        }
        //2. DB에 신규회원 정보를 저장
        return "registerInfo";
    }

    private boolean isValid(User user) {
        return true;
    }
}
