package com.example.demo.entities.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;


final public class JanitorDto{
    private String name;
    private String surname;
    private int salary;
    private int cash;
    private int cleaningQuality;
    @Id
    @GeneratedValue
    private UUID id;

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

    public void setCleaningQuality(int cleaningQuality) {
        this.cleaningQuality = cleaningQuality;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public JanitorDto(String name, String surname, int cash, int salary, int cleaningQuality){
        this.name = name;
        this.surname = surname;
        this.cash = cash;
        this.salary = salary;
        this.cleaningQuality = cleaningQuality;
    }

    public JanitorDto() {

    }

    public int getCleaningQuality(){
        return this.cleaningQuality;
    }

    public UUID getId(){return this.id;}

}