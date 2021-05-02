package com.aaqanddev.jdnd.course1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String getHomePage(Model model){
        model.addAttribute("greetings", List.of("boo", "yah", "no way", "yada yada"));
        model.addAttribute("welcomeMessage", Instant.now().toString());
        return "home";
    }
}
