package com.example.demo.services;

import com.example.demo.entities.Dorm;
import org.springframework.stereotype.Service;

@Service
final public class PartyService {
    public void party(Dorm dorm){
        dorm.setCleanliness(-30);
    }
}
