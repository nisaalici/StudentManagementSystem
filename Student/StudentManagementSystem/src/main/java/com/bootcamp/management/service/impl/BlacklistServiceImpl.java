package com.bootcamp.management.service.impl;

import com.bootcamp.management.entity.Blacklist;
import com.bootcamp.management.exception.ResourceNotFoundException;
import com.bootcamp.management.repository.BlacklistRepository;
import com.bootcamp.management.service.BlacklistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlacklistServiceImpl implements BlacklistService {

    private final BlacklistRepository blacklistRepository;

    public BlacklistServiceImpl(BlacklistRepository blacklistRepository) {
        this.blacklistRepository = blacklistRepository;
    }

    @Override
    public Blacklist addToBlacklist(Blacklist blacklist) {
        return blacklistRepository.save(blacklist);
    }

    @Override
    public Blacklist getBlacklistEntryById(Long id) {
        return blacklistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Blacklist entry not found with id: " + id));
    }

    @Override
    public List<Blacklist> getAllBlacklistedEntries() {
        return blacklistRepository.findAll();
    }

    @Override
    public Blacklist getBlacklistEntryByEmail(String email) {
        return blacklistRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Blacklist entry not found with email: " + email));
    }

    @Override
    public boolean isEmailBlacklisted(String email) {
        return blacklistRepository.existsByEmail(email);
    }

    @Override
    public Blacklist updateBlacklistEntry(Long id, Blacklist blacklistDetails) {
        Blacklist blacklist = getBlacklistEntryById(id);
        
        blacklist.setApplicantName(blacklistDetails.getApplicantName());
        blacklist.setEmail(blacklistDetails.getEmail());
        blacklist.setReason(blacklistDetails.getReason());
        blacklist.setBlacklistDate(blacklistDetails.getBlacklistDate());
        
        return blacklistRepository.save(blacklist);
    }

    @Override
    public void removeFromBlacklist(Long id) {
        Blacklist blacklist = getBlacklistEntryById(id);
        blacklistRepository.delete(blacklist);
    }
}