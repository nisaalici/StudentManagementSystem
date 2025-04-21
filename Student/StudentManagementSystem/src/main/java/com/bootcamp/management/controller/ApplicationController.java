package com.bootcamp.management.controller;

import com.bootcamp.management.entity.Application;
import com.bootcamp.management.entity.ApplicationState;
import com.bootcamp.management.service.ApplicationService;
import com.bootcamp.management.service.BlacklistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;
    private final BlacklistService blacklistService;

    public ApplicationController(ApplicationService applicationService, BlacklistService blacklistService) {
        this.applicationService = applicationService;
        this.blacklistService = blacklistService;
    }

    @PostMapping
    public ResponseEntity<?> createApplication(@RequestBody Application application) {
        // Check if email is blacklisted
        if (blacklistService.isEmailBlacklisted(application.getEmail())) {
            return ResponseEntity.badRequest().body("Email is blacklisted and cannot apply");
        }
        return new ResponseEntity<>(applicationService.createApplication(application), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Application> getApplicationById(@PathVariable Long id) {
        return ResponseEntity.ok(applicationService.getApplicationById(id));
    }

    @GetMapping
    public ResponseEntity<List<Application>> getAllApplications() {
        return ResponseEntity.ok(applicationService.getAllApplications());
    }

    @GetMapping("/bootcamp/{bootcampId}")
    public ResponseEntity<List<Application>> getApplicationsByBootcampId(@PathVariable Long bootcampId) {
        return ResponseEntity.ok(applicationService.getApplicationsByBootcampId(bootcampId));
    }

    @GetMapping("/state/{state}")
    public ResponseEntity<List<Application>> getApplicationsByState(@PathVariable ApplicationState state) {
        return ResponseEntity.ok(applicationService.getApplicationsByState(state));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<Application>> getApplicationsByEmail(@PathVariable String email) {
        return ResponseEntity.ok(applicationService.getApplicationsByEmail(email));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Application> updateApplication(@PathVariable Long id, @RequestBody Application application) {
        return ResponseEntity.ok(applicationService.updateApplication(id, application));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
        return ResponseEntity.noContent().build();
    }
}