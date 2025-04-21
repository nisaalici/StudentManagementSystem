package com.bootcamp.management.repository;

import com.bootcamp.management.entity.Blacklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlacklistRepository extends JpaRepository<Blacklist, Long> {
    Optional<Blacklist> findByEmail(String email);
    boolean existsByEmail(String email);
}