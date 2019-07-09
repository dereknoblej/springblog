package com.codeup.springblog;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    private UserRepository userDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users2/signUp";
    }

    @PostMapping("/sign-up")
    public String saveUser(@Valid User user, Errors validation, Model model){
        System.out.println(user.getUsername());
        System.out.println(userDao.findByUsername(user.getUsername()));
        if(userDao.findByUsername(user.getUsername()) != null ){
            validation.rejectValue("username",null, "Username is already in use");
        }
        if(validation.hasErrors()){
            model.addAttribute("errors",validation);
            return "users2/signUp";
        }

        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:login";

    }
}