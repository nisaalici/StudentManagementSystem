package com.bootcamp.management.service;

import com.bootcamp.management.entity.Bootcamp;
import com.bootcamp.management.entity.BootcampState;

import java.util.List;

public interface BootcampService {
    Bootcamp createBootcamp(Bootcamp bootcamp);
    Bootcamp getBootcampById(Long id);
    List<Bootcamp> getAllBootcamps();
    List<Bootcamp> getBootcampsByState(BootcampState state);
    Bootcamp updateBootcamp(Long id, Bootcamp bootcamp);
    void deleteBootcamp(Long id);
}