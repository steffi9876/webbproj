package com.example.webbproj.controller;

import com.example.webbproj.model.JobApplication;
import com.example.webbproj.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class JobApplicationController {
    @Autowired
    private JobApplicationService service;

    @GetMapping
    public List<JobApplication> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public JobApplication getById(@PathVariable Long id) {
        return service.getById(id).orElse(null);
    }

    @PostMapping
    public JobApplication create(@RequestBody JobApplication application) {
        return service.create(application);
    }

    @PutMapping("/{id}")
    public JobApplication update(@PathVariable Long id, @RequestBody JobApplication updated) {
        return service.update(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
