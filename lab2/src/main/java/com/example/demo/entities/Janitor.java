package com.example.demo.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "janitors")
final public class Janitor{
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private int salary;
    @Column
    private int cash;
    @Column
    private int cleaningQuality;
    @Id
    @GeneratedValue
    private UUID id;

    public Janitor( String name, String surname, int cash, int salary, int cleaningQuality){
        this.name = name;
        this.surname = surname;
        this.cash = cash;
        this.salary = salary;
        this.cleaningQuality = cleaningQuality;
    }

    public void monthSalary(){
        this.cash += this.salary;
    }

    public Janitor() {
    }

    public int getCleaningQuality(){
        return this.cleaningQuality;
    }

    public void addId(){this.id = UUID.randomUUID();}

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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
