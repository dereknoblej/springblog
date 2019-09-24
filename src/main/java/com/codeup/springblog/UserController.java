package com.codeup.springblog;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
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
        return "users/signUp";
    }

    @PostMapping("/sign-up")
    public String saveUser(@Valid User user, Errors validation, Model model) throws UnirestException {
        if(userDao.findByUsername(user.getUsername()) != null ){
            validation.rejectValue("username",null, "Username is already in use");
        }
        if(validation.hasErrors()){
            model.addAttribute("errors",validation);
            return "users/signUp";
        }

        double randomNum = Math.random() * 5000;

        final String API_KEY = "";
        final String DOMAIN_NAME = "mg.dnohomework.com";

        HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/"+ DOMAIN_NAME +"/messages")
                .basicAuth("api", API_KEY )

                .queryString("from",  user.getUsername() + " <USER@dnohomework.COM>")
                .queryString("to", "derek.noblej@gmail.com")
                .queryString("subject", user.getEmail())
                .queryString("text", randomNum)
                .asJson();
        request.getBody();

        user.setVerifyCode(randomNum);
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:login";

    }
}