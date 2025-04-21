package com.bootcamp.management.repository;

import com.bootcamp.management.entity.Bootcamp;
import com.bootcamp.management.entity.BootcampState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BootcampRepository extends JpaRepository<Bootcamp, Long> {
    List<Bootcamp> findByState(BootcampState state);
}