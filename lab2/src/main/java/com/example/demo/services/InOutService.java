package com.example.demo.services;

import com.example.demo.entities.Dorm;
import com.example.demo.entities.Student;
import com.example.demo.repo.StudentRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InOutService {
    @Autowired
    StudentRepository studentRepository;

   public void moveIn(Dorm dorm, Student student){
        if (dorm.getNumOfFreeRooms() > 0) {
            student.setDormNumber(dorm.getDormNumber());
            dorm.changeRooms(-1);
        }
   }

   public void kickOut(Dorm dorm, Student student){
       student.setDormNumber(0);
        dorm.changeRooms(1);
        student.setRoomNumber(0);
   }

   @Transactional
   public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

   @Transactional
   public Student getStudentById(UUID id) throws NotFoundException {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent())
            return student.get();
        else
            throw new NotFoundException(String.format("Student %s does not exists.",id));
   }

   @Transactional
   public void addStudent(Student student) {
        studentRepository.save(student);
    }

   public void deleteById(UUID id){
        studentRepository.deleteById(id);
    }
}
