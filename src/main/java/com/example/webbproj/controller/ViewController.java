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
    @Autowired
    private JobApplicationService service;


    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/applications")
    public String viewApplications(Model model) {
        model.addAttribute("applications", service.getAll());
        return "applications";
    }

    @GetMapping("/applications/new")
    public String showAddForm(Model model) {
        model.addAttribute("jobApplication", new JobApplication());
        return "new-application";
    }

    @PostMapping("/applications")
    public String submitApplication(
            @Valid @ModelAttribute("jobApplication") JobApplication jobApplication,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            return "new-application";
        }

        service.save(jobApplication);
        return "redirect:/applications";
    }

    @GetMapping("/applications/delete/{id}")
    public String deleteApplication(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/applications";
    }

    @GetMapping("/applications/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        JobApplication application = service.findById(id);
        model.addAttribute("jobApplication", application);
        return "edit-application";
    }

    @PostMapping("/applications/update/{id}")
    public String updateApplication(@PathVariable Long id,
                                    @Valid @ModelAttribute("jobApplication") JobApplication jobApplication,
                                    BindingResult result) {
        if (result.hasErrors()) {
            return "edit-application";
        }

        jobApplication.setId(id); // viktigt så att rätt post uppdateras
        service.save(jobApplication);
        return "redirect:/applications";
    }


}
