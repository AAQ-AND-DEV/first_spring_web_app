package com.aaqanddev.jdnd.course1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private Boolean firstVisit;

    @Autowired
    private String[] greetings;

    @RequestMapping("/home")
    public String getHomePage(Model model){
        model.addAttribute("greetings", List.of("boo", "yah", "no way", "yada yada"));
        model.addAttribute("welcomeMessage", Instant.now().toString());
        model.addAttribute("firstVisit", firstVisit);
        model.addAttribute("hello", greetings[0]);
        model.addAttribute("welcomeBack", greetings[1]);
        return "home";
    }

    @PostMapping("/simplehome")
    public String getSimpleHomePage(Model model){
        return "simplehome";
    }
}
