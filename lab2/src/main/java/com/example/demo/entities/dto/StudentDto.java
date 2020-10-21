package com.example.demo.entities.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "students")

final public class StudentDto extends PersonDto{

    private int roomNumber;
    private boolean isInsideDorm;
    @Id
    @GeneratedValue
    private UUID id;
    private int dormNumber = 0;

    public StudentDto( String name, String surname, int cash, int salary, int roomNumber){
        super( name, surname, cash, salary);
        this.roomNumber = roomNumber;
        this.isInsideDorm = false;
    }

    public StudentDto() {
        super("Ivan","Ivanov",0,0);
    }

    public void enterDorm(){
        this.isInsideDorm = true;
    }

    public void setDormNumber(int value){
        this.dormNumber = value;
    }

    public int getRoomNumber(){return this.roomNumber;}

    public void setRoomNumber(int value){
        this.roomNumber = value;
    }

    public void leaveDorm(){
        this.isInsideDorm = false;
    }

    public UUID getId(){return this.id;}
}