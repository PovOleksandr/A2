package com.example.demo.services;

import com.example.demo.entities.Watchman;
import com.example.demo.entities.Student;
import com.example.demo.repo.WatchmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
public class EntranceService {
    @Autowired
    WatchmanRepository watchmanRepository;

    public void tryToEnter(Student student, Watchman watchman){
        if( student.getRoomNumber() != 0){
            student.enterDorm();
        }else if( student.getCash() >= watchman.getBribeNeeded()){
            student.enterDorm();
            student.setCash( -watchman.getBribeNeeded() );
            watchman.setCash( watchman.getBribeNeeded() );
        }
    }
    @Transactional
    public void addWatchman(Watchman watchman){
        watchmanRepository.save(watchman);
    }

    public void deleteById(UUID id){
        watchmanRepository.deleteById(id);
    }
}
