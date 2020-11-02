package com.example.demo.entities.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "students")

final public class StudentDto{
    private String name;
    private String surname;
    private int salary;
    private int cash;
    private int roomNumber;
    private boolean isInsideDorm;
    @Id
    @GeneratedValue
    private UUID id;
    private int dormNumber = 0;

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

    public void setId(UUID id) {
        this.id = id;
    }

    public int getDormNumber() {
        return dormNumber;
    }

    public StudentDto(String name, String surname, int cash, int salary, int roomNumber){
        this.name = name;
        this.surname = surname;
        this.cash = cash;
        this.salary = salary;
        this.roomNumber = roomNumber;
        this.isInsideDorm = false;
    }

    public StudentDto() {

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