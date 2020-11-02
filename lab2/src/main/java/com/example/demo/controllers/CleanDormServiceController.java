package com.example.demo.controllers;

import com.example.demo.entities.Student;
import com.example.demo.entities.dto.CleanDto;
import com.example.demo.entities.dto.DormDto;
import com.example.demo.entities.dto.JanitorDto;
import com.example.demo.entities.dto.StudentDto;
import com.example.demo.repo.DormRepository;
import com.example.demo.repo.JanitorRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.CleanDormService;
import com.example.demo.entities.Dorm;
import com.example.demo.entities.Janitor;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clean")
public class CleanDormServiceController {
    @Autowired
    CleanDormService cleanDormService;

    @GetMapping
    public ResponseEntity<List<Janitor>> show() {
        return ResponseEntity.ok(cleanDormService.getAllJanitors());
    }

    @GetMapping("{id}")
    public ResponseEntity<Janitor> showById(@PathVariable UUID id) throws NotFoundException {
        return ResponseEntity.ok(cleanDormService.getJanitorById(id));
    }

    @PostMapping(path="/cleanDorm")
    public void cleanDorm(@RequestBody CleanDto cleanDto){
        Janitor janitor = cleanDto.getJanitor();
        Dorm dorm = cleanDto.getDorm();
        cleanDormService.cleanDorm(janitor,dorm);
    }

    @PostMapping(path="/crJanitor")
    public ResponseEntity<Void> createJanitor(@RequestBody JanitorDto janitorDto){
        Janitor janitor = new Janitor(janitorDto.getName(),janitorDto.getSurname(),
                janitorDto.getCash(),janitorDto.getSalary(),janitorDto.getCleaningQuality());
        janitor.addId();
        cleanDormService.addJanitor(janitor);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{janitorId}")
    public ResponseEntity<Void> deleteJanitor(@PathVariable(value = "janitorId") UUID id) {
        cleanDormService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
