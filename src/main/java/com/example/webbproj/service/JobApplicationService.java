package com.example.webbproj.service;

import com.example.webbproj.model.JobApplication;
import com.example.webbproj.repository.JobApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobApplicationService {

    @Autowired
    private JobApplicationRepository repository;

    public List<JobApplication> getAll() {
        return repository.findAll();
    }

    public Optional<JobApplication> getById(Long id) {
        return repository.findById(id);
    }

    public JobApplication create(JobApplication application) {
        return repository.save(application);
    }

    public JobApplication update(Long id, JobApplication updated) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setCompany(updated.getCompany());
                    existing.setPosition(updated.getPosition());
                    existing.setApplicationDate(updated.getApplicationDate());
                    existing.setContactPerson(updated.getContactPerson());
                    existing.setStatus(updated.getStatus());
                    existing.setNotes(updated.getNotes());
                    return repository.save(existing);
                })
                .orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
