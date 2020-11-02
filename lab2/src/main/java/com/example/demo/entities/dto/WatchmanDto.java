package com.example.demo.entities.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name="watchmans")
final public class WatchmanDto{
    private String name;
    private String surname;
    private int salary;
    private int cash;
    private int bribeNeeded;
    @Id
    @GeneratedValue
    private UUID id;
    public WatchmanDto(String name, String surname, int cash, int bribeNeeded, int salary){
        this.name = name;
        this.surname = surname;
        this.cash = cash;
        this.salary = salary;
        this.bribeNeeded = bribeNeeded;
    }

    public WatchmanDto() {

    }

    public int getBribeNeeded(){
        return this.bribeNeeded;
    }

    public UUID getId(){return this.id;}

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

    public void setBribeNeeded(int bribeNeeded) {
        this.bribeNeeded = bribeNeeded;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
