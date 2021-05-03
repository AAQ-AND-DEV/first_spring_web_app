package com.aaqanddev.jdnd.course1.controller;

import com.aaqanddev.jdnd.course1.model.MessageForm;
import com.aaqanddev.jdnd.course1.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class HomeController {

    private MessageService messageService;

    public HomeController(MessageService messageService) {
        this.messageService = messageService;
    }

    @Autowired
    private Boolean firstVisit;

    @Autowired
    private String[] greetings;

    @GetMapping("/home")
    public String getHomePage(@ModelAttribute("newMessage") MessageForm newMessage, Model model){
        model.addAttribute("greetings", List.of("boo", "yah", "no way", "yada yada"));
        model.addAttribute("messageList", this.messageService.getMessages());
        model.addAttribute("welcomeMessage", Instant.now().toString());
        model.addAttribute("firstVisit", firstVisit);
        model.addAttribute("hello", greetings[0]);
        model.addAttribute("welcomeBack", greetings[1]);
        return "home";
    }

    @PostMapping("/home")
    public String addMessage(@ModelAttribute("newMessage") MessageForm messageForm, Model model){
        messageService.addMessage(messageForm.getText());
        model.addAttribute("messageList", messageService.getMessages());
        messageForm.setText("");
        return "home";
    }

    @PostMapping("/simplehome")
    public String getSimpleHomePage(Model model){
        return "simplehome";
    }


}
