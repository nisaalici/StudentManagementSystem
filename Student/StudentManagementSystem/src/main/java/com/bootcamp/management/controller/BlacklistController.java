package com.bootcamp.management.controller;

import com.bootcamp.management.entity.Blacklist;
import com.bootcamp.management.service.BlacklistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blacklist")
public class BlacklistController {

    private final BlacklistService blacklistService;

    public BlacklistController(BlacklistService blacklistService) {
        this.blacklistService = blacklistService;
    }

    @PostMapping
    public ResponseEntity<Blacklist> addToBlacklist(@RequestBody Blacklist blacklist) {
        return new ResponseEntity<>(blacklistService.addToBlacklist(blacklist), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blacklist> getBlacklistEntryById(@PathVariable Long id) {
        return ResponseEntity.ok(blacklistService.getBlacklistEntryById(id));
    }

    @GetMapping
    public ResponseEntity<List<Blacklist>> getAllBlacklistedEntries() {
        return ResponseEntity.ok(blacklistService.getAllBlacklistedEntries());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Blacklist> getBlacklistEntryByEmail(@PathVariable String email) {
        return ResponseEntity.ok(blacklistService.getBlacklistEntryByEmail(email));
    }

    @GetMapping("/check/{email}")
    public ResponseEntity<Boolean> isEmailBlacklisted(@PathVariable String email) {
        return ResponseEntity.ok(blacklistService.isEmailBlacklisted(email));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blacklist> updateBlacklistEntry(@PathVariable Long id, @RequestBody Blacklist blacklist) {
        return ResponseEntity.ok(blacklistService.updateBlacklistEntry(id, blacklist));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeFromBlacklist(@PathVariable Long id) {
        blacklistService.removeFromBlacklist(id);
        return ResponseEntity.noContent().build();
    }
}