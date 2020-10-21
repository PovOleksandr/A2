package com.example.demo.controllers;


import com.example.demo.entities.Dorm;
import com.example.demo.entities.Student;
import com.example.demo.entities.Watchman;
import com.example.demo.entities.dto.EntranceDto;
import com.example.demo.entities.dto.StudentDto;
import com.example.demo.entities.dto.WatchmanDto;
import com.example.demo.repo.StudentRepository;
import com.example.demo.repo.WatchmanRepository;
import com.example.demo.services.EntranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/entrance")
public class EntranceServiceController {
    @Autowired
    EntranceService entranceService;

    @PostMapping(path="/crWatchman")
    public ResponseEntity<Void> createWatchman(@RequestBody WatchmanDto watchmanDto){
        Watchman watchman = new Watchman(watchmanDto.getName(),watchmanDto.getSurname(),
                watchmanDto.getCash(),watchmanDto.getSalary(),watchmanDto.getBribeNeeded());
        watchman.addId();
        entranceService.addWatchman(watchman);
        return ResponseEntity.ok().build();
    }

    @PostMapping(path="/tryToEnter")
    public void tryToEnter(@RequestBody EntranceDto entranceDto){
        Student student = entranceDto.getStudent();
        Watchman watchman = entranceDto.getWatchman();
        entranceService.tryToEnter(student, watchman);
    }

    @DeleteMapping("{watchmanId}")
    public ResponseEntity<Void> deleteWatchman(@PathVariable(value = "watchmanId") UUID id) {
        entranceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
