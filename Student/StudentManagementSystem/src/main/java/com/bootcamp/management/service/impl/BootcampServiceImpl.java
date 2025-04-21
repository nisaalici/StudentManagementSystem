package com.bootcamp.management.service.impl;

import com.bootcamp.management.entity.Bootcamp;
import com.bootcamp.management.entity.BootcampState;
import com.bootcamp.management.exception.ResourceNotFoundException;
import com.bootcamp.management.repository.BootcampRepository;
import com.bootcamp.management.service.BootcampService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BootcampServiceImpl implements BootcampService {

    private final BootcampRepository bootcampRepository;

    public BootcampServiceImpl(BootcampRepository bootcampRepository) {
        this.bootcampRepository = bootcampRepository;
    }

    @Override
    public Bootcamp createBootcamp(Bootcamp bootcamp) {
        return bootcampRepository.save(bootcamp);
    }

    @Override
    public Bootcamp getBootcampById(Long id) {
        return bootcampRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bootcamp not found with id: " + id));
    }

    @Override
    public List<Bootcamp> getAllBootcamps() {
        return bootcampRepository.findAll();
    }

    @Override
    public List<Bootcamp> getBootcampsByState(BootcampState state) {
        return bootcampRepository.findByState(state);
    }

    @Override
    public Bootcamp updateBootcamp(Long id, Bootcamp bootcampDetails) {
        Bootcamp bootcamp = getBootcampById(id);
        
        bootcamp.setName(bootcampDetails.getName());
        bootcamp.setStartDate(bootcampDetails.getStartDate());
        bootcamp.setEndDate(bootcampDetails.getEndDate());
        bootcamp.setState(bootcampDetails.getState());
        
        return bootcampRepository.save(bootcamp);
    }

    @Override
    public void deleteBootcamp(Long id) {
        Bootcamp bootcamp = getBootcampById(id);
        bootcampRepository.delete(bootcamp);
    }
}