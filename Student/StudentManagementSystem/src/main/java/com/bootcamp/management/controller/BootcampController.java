package com.bootcamp.management.controller;

import com.bootcamp.management.entity.Bootcamp;
import com.bootcamp.management.entity.BootcampState;
import com.bootcamp.management.service.BootcampService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bootcamps")
public class BootcampController {

    private final BootcampService bootcampService;

    public BootcampController(BootcampService bootcampService) {
        this.bootcampService = bootcampService;
    }

    @PostMapping
    public ResponseEntity<Bootcamp> createBootcamp(@RequestBody Bootcamp bootcamp) {
        return new ResponseEntity<>(bootcampService.createBootcamp(bootcamp), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bootcamp> getBootcampById(@PathVariable Long id) {
        return ResponseEntity.ok(bootcampService.getBootcampById(id));
    }

    @GetMapping
    public ResponseEntity<List<Bootcamp>> getAllBootcamps() {
        return ResponseEntity.ok(bootcampService.getAllBootcamps());
    }

    @GetMapping("/state/{state}")
    public ResponseEntity<List<Bootcamp>> getBootcampsByState(@PathVariable BootcampState state) {
        return ResponseEntity.ok(bootcampService.getBootcampsByState(state));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bootcamp> updateBootcamp(@PathVariable Long id, @RequestBody Bootcamp bootcamp) {
        return ResponseEntity.ok(bootcampService.updateBootcamp(id, bootcamp));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBootcamp(@PathVariable Long id) {
        bootcampService.deleteBootcamp(id);
        return ResponseEntity.noContent().build();
    }
}