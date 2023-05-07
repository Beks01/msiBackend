package com.example.msiproject.controller;


import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/hello")
    public String sayHello(Model model) {
        model.addAttribute("name", "Felix");
        return "hello";
    }
    @GetMapping("/index")
    public String mainPage(Model model) {
        model.addAttribute("mainPage", "Felix");
        return "hello";
    }


}