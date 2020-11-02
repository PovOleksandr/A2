package com.example.demo.services;

import com.example.demo.entities.Janitor;
import com.example.demo.entities.Dorm;
import com.example.demo.repo.JanitorRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CleanDormService {
    @Autowired
    private JanitorRepository janitorRepository;

    @Transactional
    public void addJanitor(Janitor janitor) {
        janitorRepository.save(janitor);
    }

    @Transactional
    public List<Janitor> getAllJanitors(){
        return janitorRepository.findAll();
    }

    @Transactional
    public Janitor getJanitorById(UUID id) throws NotFoundException {
        Optional<Janitor> janitor = janitorRepository.findById(id);
        if (janitor.isPresent())
            return janitor.get();
        else
            throw new NotFoundException(String.format("Janitor %s does not exists.",id));
    }

    public void cleanDorm(Janitor janitor, Dorm dorm){
        if( 100 - dorm.getCleanliness() >= janitor.getCleaningQuality()) {
            dorm.setCleanliness(janitor.getCleaningQuality());
            janitor.setCash(janitor.getSalary());
        }
    }

    public void deleteById(UUID id){
        janitorRepository.deleteById(id);
    }
}
