package com.bootcamp.management.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "applications")
public class Application {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String applicantName;
    
    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String about;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ApplicationState state;
    
    @Column(nullable = false)
    private LocalDateTime applicationDate;
    
    @ManyToOne
    @JoinColumn(name = "bootcamp_id", nullable = false)
    private Bootcamp bootcamp;
    
    public Application() {
    }
    
    public Application(Long id, String applicantName, String email, String about, ApplicationState state, LocalDateTime applicationDate, Bootcamp bootcamp) {
        this.id = id;
        this.applicantName = applicantName;
        this.email = email;
        this.about = about;
        this.state = state;
        this.applicationDate = applicationDate;
        this.bootcamp = bootcamp;
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
    
    public String getAbout() {
        return about;
    }
    
    public void setAbout(String about) {
        this.about = about;
    }
    
    public ApplicationState getState() {
        return state;
    }
    
    public void setState(ApplicationState state) {
        this.state = state;
    }
    
    public LocalDateTime getApplicationDate() {
        return applicationDate;
    }
    
    public void setApplicationDate(LocalDateTime applicationDate) {
        this.applicationDate = applicationDate;
    }
    
    public Bootcamp getBootcamp() {
        return bootcamp;
    }
    
    public void setBootcamp(Bootcamp bootcamp) {
        this.bootcamp = bootcamp;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return Objects.equals(id, that.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", applicantName='" + applicantName + '\'' +
                ", email='" + email + '\'' +
                ", state=" + state +
                ", applicationDate=" + applicationDate +
                '}';
    }
}