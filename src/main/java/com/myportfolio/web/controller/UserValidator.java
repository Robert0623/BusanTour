package com.myportfolio.web.controller;

import com.myportfolio.web.domain.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Date;

public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        System.out.println("UserValidator is called");
        User user = (User) target;
        String id = user.getId();
        String pwd = user.getPwd();

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required");

        if((4 <= id.length() && id.length() <= 12) && (pwd == null || (pwd.trim().equals("")))) {
            errors.rejectValue("pwd", "required", null);
        }

        if (id != null && !(id.trim().equals("")) && !(4 <= id.length() && id.length() <= 12)) {
            errors.rejectValue("id", "invalidLength", new String[]{"4", "12"}, null);
        }
        if ((4 <= id.length() && id.length() <= 12) && pwd != null && !(pwd.trim().equals("")) && !(4 <= pwd.length() && pwd.length() <= 12)) {
            errors.rejectValue("pwd", "invalidLength", new String[]{"4", "12"}, null);
        }
    }
}
