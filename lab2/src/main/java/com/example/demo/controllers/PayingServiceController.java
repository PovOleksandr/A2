package com.example.demo.controllers;


import com.example.demo.entities.Dorm;
import com.example.demo.entities.dto.DormDto;
import com.example.demo.repo.DormRepository;
import com.example.demo.repo.StudentRepository;
import com.example.demo.services.PayingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/dorm")
public class PayingServiceController {
    @Autowired
    PayingService payingService;
    DormRepository dormRepository;

    @PostMapping(path="/crDorm")
    public ResponseEntity<Void> createDorm(@RequestBody DormDto dormDto){
        Dorm dorm = new Dorm(dormDto.getDormNumber(),dormDto.getCleanliness(),
                dormDto.getNumOfFreeRooms(),dormDto.getMonthPrice());

        payingService.addDorm(dorm);
        return ResponseEntity.ok().build();
    }

    @PostMapping(name="/pay")
    public void payForDorm(@RequestBody DormDto dormDto){
        Dorm dorm = dormRepository.getOne(dormDto.getId());
        payingService.payingForDorm(dorm);}

    @DeleteMapping("{dormId}")
    public ResponseEntity<Void> deleteDorm(@PathVariable(value = "dormId") UUID id) {
        payingService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
