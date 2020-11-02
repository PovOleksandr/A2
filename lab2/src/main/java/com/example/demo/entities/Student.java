package com.example.demo.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "students")

final public class Student{
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private int salary;
    @Column
    private int cash;
    @Column
    private int roomNumber;
    @Column
    private boolean isInsideDorm;
    @Id
    @GeneratedValue
    private UUID id;
    @Column
    private int dormNumber = 0;

    public void monthSalary(){
        this.cash += this.salary;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public boolean isInsideDorm() {
        return isInsideDorm;
    }

    public void setInsideDorm(boolean insideDorm) {
        isInsideDorm = insideDorm;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getDormNumber() {
        return dormNumber;
    }

    public Student(String name, String surname, int cash, int salary, int roomNumber){
        this.name = name;
        this.surname = surname;
        this.cash = cash;
        this.salary = salary;
        this.roomNumber = roomNumber;
        this.isInsideDorm = false;
    }

    public Student() {
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
