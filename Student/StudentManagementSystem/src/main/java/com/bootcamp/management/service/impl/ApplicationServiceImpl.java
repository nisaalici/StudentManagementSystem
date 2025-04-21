package com.bootcamp.management.service.impl;

import com.bootcamp.management.entity.Application;
import com.bootcamp.management.entity.ApplicationState;
import com.bootcamp.management.exception.ResourceNotFoundException;
import com.bootcamp.management.repository.ApplicationRepository;
import com.bootcamp.management.service.ApplicationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public Application createApplication(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public Application getApplicationById(Long id) {
        return applicationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Application not found with id: " + id));
    }

    @Override
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    @Override
    public List<Application> getApplicationsByBootcampId(Long bootcampId) {
        return applicationRepository.findByBootcampId(bootcampId);
    }

    @Override
    public List<Application> getApplicationsByState(ApplicationState state) {
        return applicationRepository.findByState(state);
    }

    @Override
    public List<Application> getApplicationsByEmail(String email) {
        return applicationRepository.findByEmail(email);
    }

    @Override
    public Application updateApplication(Long id, Application applicationDetails) {
        Application application = getApplicationById(id);
        
        application.setApplicantName(applicationDetails.getApplicantName());
        application.setEmail(applicationDetails.getEmail());
        application.setAbout(applicationDetails.getAbout());
        application.setState(applicationDetails.getState());
        
        return applicationRepository.save(application);
    }

    @Override
    public void deleteApplication(Long id) {
        Application application = getApplicationById(id);
        applicationRepository.delete(application);
    }
}