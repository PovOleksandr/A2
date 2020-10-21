package com.example.demo.entities.dto;

import com.example.demo.entities.Dorm;
import com.example.demo.entities.Student;

public class MoveInKickOutDto {
    private Student student;
    private Dorm dorm;
    public MoveInKickOutDto(Student student, Dorm dorm){
        this.student = student;
        this.dorm = dorm;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Dorm getDorm() {
        return dorm;
    }

    public void setDorm(Dorm dorm) {
        this.dorm = dorm;
    }
}
