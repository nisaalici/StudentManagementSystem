package com.bootcamp.management.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "blacklist")
public class Blacklist {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String applicantName;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false)
    private String reason;
    
    @Column(nullable = false)
    private LocalDate blacklistDate;
    
    public Blacklist() {
    }
    
    public Blacklist(Long id, String applicantName, String email, String reason, LocalDate blacklistDate) {
        this.id = id;
        this.applicantName = applicantName;
        this.email = email;
        this.reason = reason;
        this.blacklistDate = blacklistDate;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getApplicantName() {
        return applicantName;
    }
    
    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getReason() {
        return reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }
    
    public LocalDate getBlacklistDate() {
        return blacklistDate;
    }
    
    public void setBlacklistDate(LocalDate blacklistDate) {
        this.blacklistDate = blacklistDate;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blacklist blacklist = (Blacklist) o;
        return Objects.equals(id, blacklist.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    @Override
    public String toString() {
        return "Blacklist{" +
                "id=" + id +
                ", applicantName='" + applicantName + '\'' +
                ", email='" + email + '\'' +
                ", reason='" + reason + '\'' +
                ", blacklistDate=" + blacklistDate +
                '}';
    }
}