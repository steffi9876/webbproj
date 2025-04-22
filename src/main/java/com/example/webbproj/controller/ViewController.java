package com.example.webbproj.controller;

import com.example.webbproj.model.JobApplication;
import com.example.webbproj.service.JobApplicationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ViewController {
    /*@Autowired
    private JobApplicationService service;

    @GetMapping("/applications")
    public String viewApplications(Model model) {
        model.addAttribute("applications", service.getAll());
        return "applications"; // thymeleaf .html i templates
    }*/


    @Autowired
    private JobApplicationService service;

    @GetMapping("/applications")
    public String viewApplications(Model model) {
        model.addAttribute("applications", service.getAll());
        model.addAttribute("jobApplication", new JobApplication()); // behövs för formuläret
        return "applications";
    }

    @PostMapping("/applications")
    public String submitApplication(
            @Valid @ModelAttribute("jobApplication") JobApplication jobApplication,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("applications", service.getAll());
            return "applications";
        }

        service.save(jobApplication);
        return "redirect:/applications";
    }

    @GetMapping("/applications/delete/{id}")
    public String deleteApplication(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/applications";
    }

}
