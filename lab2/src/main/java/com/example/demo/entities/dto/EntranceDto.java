package com.example.demo.entities.dto;

import com.example.demo.entities.Student;
import com.example.demo.entities.Watchman;

public class EntranceDto {
    private Watchman watchman;
    private Student student;

    public EntranceDto(Watchman watchman,Student student){
        this.watchman = watchman;
        this.student = student;
    }

    public Watchman getWatchman() {
        return watchman;
    }

    public void setWatchman(Watchman watchman) {
        this.watchman = watchman;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
