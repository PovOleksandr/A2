package com.example.demo.controllers;

import com.example.demo.entities.Dorm;
import com.example.demo.entities.dto.DormDto;
import com.example.demo.entities.dto.MoveInKickOutDto;
import com.example.demo.entities.dto.StudentDto;
import com.example.demo.repo.DormRepository;
import com.example.demo.repo.StudentRepository;
import com.example.demo.services.InOutService;
import com.example.demo.entities.Student;
import com.example.demo.services.PayingService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/students")
public class InOutServiceController {
    @Autowired
    InOutService ioService;
    PayingService payingService;
    StudentRepository studentRepository;
    DormRepository dormRepository;

    @GetMapping
    public ResponseEntity<List<Student>> show() {
        return ResponseEntity.ok(ioService.getAllStudents());
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> showById(@PathVariable UUID id) throws NotFoundException {
        return ResponseEntity.ok(ioService.getStudentById(id));
    }

    @PostMapping(path="/salary")
    public void getSalary(){payingService.getSalary();}

    @PostMapping(path="/crStudent")
    public ResponseEntity<Void> createStudent(@RequestBody StudentDto studentDto){
        Student student = new Student(studentDto.getName(),studentDto.getSurname(),
                studentDto.getCash(),studentDto.getSalary(),studentDto.getRoomNumber());
        student.addId();
        ioService.addStudent(student);
        return ResponseEntity.ok().build();
    }

    @PostMapping(path="/moveIn")
    public void moveIn(@RequestBody MoveInKickOutDto moveInKickOutDto){
        Student student = moveInKickOutDto.getStudent();
        Dorm dorm = moveInKickOutDto.getDorm();
        ioService.moveIn(dorm,student);
    }

    @PostMapping(path="/kickedOut")
    public void kickedOut(@RequestBody DormDto dormDto, @RequestBody StudentDto studentDto){
        Student student = studentRepository.getOne(studentDto.getId());
        Dorm dorm = dormRepository.getOne(dormDto.getId());
        ioService.kickOut(dorm,student);
    }

    @DeleteMapping("{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable(value = "studentId") UUID id) {
        ioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
