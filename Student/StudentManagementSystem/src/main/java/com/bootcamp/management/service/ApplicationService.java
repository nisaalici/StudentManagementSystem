package com.bootcamp.management.service;

import com.bootcamp.management.entity.Application;
import com.bootcamp.management.entity.ApplicationState;

import java.util.List;

public interface ApplicationService {
    Application createApplication(Application application);
    Application getApplicationById(Long id);
    List<Application> getAllApplications();
    List<Application> getApplicationsByBootcampId(Long bootcampId);
    List<Application> getApplicationsByState(ApplicationState state);
    List<Application> getApplicationsByEmail(String email);
    Application updateApplication(Long id, Application application);
    void deleteApplication(Long id);
}