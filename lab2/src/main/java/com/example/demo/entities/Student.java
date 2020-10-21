package com.example.demo.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "students")

final public class Student extends Person{
    @Column
    private int roomNumber;
    @Column
    private boolean isInsideDorm;
    @Id
    @GeneratedValue
    private UUID id;
    @Column
    private int dormNumber = 0;

    public Student( String name, String surname, int cash, int salary, int roomNumber){
        super( name, surname, cash, salary);
        this.roomNumber = roomNumber;
        this.isInsideDorm = false;
    }

    public Student() {
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

    public void addId(){this.id = UUID.randomUUID();}
}
