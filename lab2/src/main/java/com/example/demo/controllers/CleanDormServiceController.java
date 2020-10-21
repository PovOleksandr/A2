package com.example.demo.controllers;

import com.example.demo.entities.Student;
import com.example.demo.entities.dto.DormDto;
import com.example.demo.entities.dto.JanitorDto;
import com.example.demo.entities.dto.StudentDto;
import com.example.demo.repo.DormRepository;
import com.example.demo.repo.JanitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.CleanDormService;
import com.example.demo.entities.Dorm;
import com.example.demo.entities.Janitor;

import java.util.UUID;

@RestController
@RequestMapping("/clean")
public class CleanDormServiceController {
    @Autowired
    CleanDormService cleanDormService;

    JanitorRepository janitorRepository;
    DormRepository dormRepository;

    @PostMapping(path="/cleanDorm")
    public void cleanDorm(@RequestBody JanitorDto janitorDto, @RequestBody DormDto dormDto){
        Janitor janitor = janitorRepository.getOne(janitorDto.getId());
        Dorm dorm = dormRepository.getOne(dormDto.getId());
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
