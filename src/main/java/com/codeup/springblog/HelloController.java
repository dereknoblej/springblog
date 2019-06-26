package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @GetMapping(path = "/hello")
    @ResponseBody
    public String hello(){
        return "<h1>Hello</h1>";
    }
    @GetMapping("/goodbye")
    @ResponseBody
    public String goodbye(){
        return "<h1>Goodbye</h1>";
    }

    //Path Variables
    @GetMapping("/hello/{name}")
    @ResponseBody
    public String helloName(@PathVariable String name){
        return "<h1>howdy " + name+"</h1>";
    }

    @GetMapping("/favnum/{num}")
    @ResponseBody
    public String getFavNum(@PathVariable int num){
        return "Fav num is = " + num;
    }

    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number){
        return number + " plus one is "+ (number + 1) + "!";
    }


}
