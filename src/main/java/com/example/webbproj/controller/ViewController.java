package com.example.webbproj.controller;

import com.example.webbproj.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @Autowired
    private JobApplicationService service;

    @GetMapping("/applications")
    public String viewApplications(Model model) {
        model.addAttribute("applications", service.getAll());
        return "applications"; // thymeleaf .html i templates
    }
}
