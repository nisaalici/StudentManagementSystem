package com.bootcamp.management.service;

import com.bootcamp.management.entity.Blacklist;

import java.util.List;

public interface BlacklistService {
    Blacklist addToBlacklist(Blacklist blacklist);
    Blacklist getBlacklistEntryById(Long id);
    List<Blacklist> getAllBlacklistedEntries();
    Blacklist getBlacklistEntryByEmail(String email);
    boolean isEmailBlacklisted(String email);
    Blacklist updateBlacklistEntry(Long id, Blacklist blacklist);
    void removeFromBlacklist(Long id);
}