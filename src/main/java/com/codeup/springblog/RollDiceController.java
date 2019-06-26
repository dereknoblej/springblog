package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.nio.file.Path;

@Controller
public class RollDiceController {
    @GetMapping("/roll-dice/{number}")
    public String diceRoll(@PathVariable int number, Model model){
       int randomNumber =  (int)(Math.random()*6) + 1;
       if(number == randomNumber){
           model.addAttribute("answer", "You entered " + number + " the dice rolled " + randomNumber + " GOOD JOB!" ) ;
       } else {
           model.addAttribute("answer", "You guessed " + number + " the correct answer was " + randomNumber) ;
       }
       return "rolldice";
    }

    @GetMapping("/roll-dice")
    public String diceGuess(){
        return "rolldice";
    }

}
