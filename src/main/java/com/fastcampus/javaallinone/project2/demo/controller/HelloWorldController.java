package com.fastcampus.javaallinone.project2.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*@Controller
@ResponseBody*/
@RestController
public class HelloWorldController {

   @GetMapping(value = "/api/helloWorld")
    public String helloWorld(){
        return "HelloWorld";
    }

}
