package com.example.demo.controllers;


import com.example.demo.entities.dto.DormDto;
import com.example.demo.repo.DormRepository;
import com.example.demo.services.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entities.Dorm;

@RestController
@RequestMapping("/party")
public class PartyServiceController {
    @Autowired
    PartyService partyService;

    @Autowired
    DormRepository dormRepository;

    @PostMapping
    public void party(@RequestBody DormDto dormDto){
        Dorm dorm = dormRepository.findDormByNumber(dormDto.getDormNumber());
        partyService.party(dorm);
    }
}
