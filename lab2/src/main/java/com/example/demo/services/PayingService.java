package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.entities.Student;
import com.example.demo.entities.Dorm;
import com.example.demo.repo.DormRepository;
import com.example.demo.repo.StudentRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PayingService {
    @Autowired
    DormRepository dormRepository;
    @Autowired
    StudentRepository studentRepository;

    public void payingForDorm(Dorm dorm){
        List<Student> toKick = new ArrayList<>();
        InOutService ioServ = new InOutService();
        List<Student> toPay = studentRepository.findStudents(dorm.getDormNumber());

        for (Student student: toPay){
            if(student.getCash()>dorm.getMonthPrice()){
                student.setCash(-dorm.getMonthPrice());
                dorm.increaceIncome(dorm.getMonthPrice());
            }else{
                student.setDormNumber(0);
                toKick.add(student);
            }
        }

        for (Student student: toKick){
            ioServ.kickOut(dorm, student);
        }
    }
    public void getSalary(){
        List<Student> paySalary = studentRepository.findAll();
        for (Student student: paySalary){
            student.monthSalary();
        }
    }

    @Transactional
    public List<Dorm> getAllDorms(){
        return dormRepository.findAll();
    }

    @Transactional
    public Dorm getDormById(UUID id) throws NotFoundException {
        Optional<Dorm> dorm = dormRepository.findById(id);
        if (dorm.isPresent())
            return dorm.get();
        else
            throw new NotFoundException(String.format("Dorm %s does not exists.",id));
    }

    @Transactional
    public void addDorm(Dorm dorm){
        dormRepository.save(dorm);
    }

    @Transactional
    public void deleteById(UUID id){
        dormRepository.deleteById(id);
    }
}
