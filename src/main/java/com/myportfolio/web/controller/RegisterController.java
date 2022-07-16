package com.myportfolio.web.controller;

import com.myportfolio.web.domain.User;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @InitBinder
    public void toDate(WebDataBinder binder) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(df2, false));
        binder.setValidator(new UserValidator());
    }

    @GetMapping("/add")
    public String register() {
        return "registerForm";
    }
    @PostMapping("/add")
    public String save(@Valid User user, BindingResult result, Model m) throws Exception {
        System.out.println("result = " + result);

//        UserValidator userValidator = new UserValidator();
//        userValidator.validate(user, result);

        if(result.hasErrors()) {
            return "registerForm";
        }

        //2. DB에 신규회원 정보를 저장
        return "registerInfo";
    }

//    private boolean isValid(User user) {
//        return true;
//    }
}
