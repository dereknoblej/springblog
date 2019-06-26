package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {

    @RequestMapping(path = "/add/{num1}/and/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String addition(@PathVariable int num1, @PathVariable int num2){
        return "The answer is " + (num1 + num2);
    }

    @RequestMapping(path = "/subtract/{num1}/from/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String subtraction(@PathVariable int num1, @PathVariable int num2){
        return "The answer is " + (num2 - num1);
    }

    @RequestMapping(path = "/multiply/{num1}/and/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String multi(@PathVariable int num1, @PathVariable int num2){
        return "The answer is " + (num2 * num1);
    }

    @RequestMapping(path = "/divide/{num1}/by/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String divide(@PathVariable int num1, @PathVariable int num2){
       try{
           int answer = num1/num2;
           return "The answer is " + answer;
       } catch (ArithmeticException e){
           throw new RuntimeException("You can not divide by 0", e);
       }



    }



}
