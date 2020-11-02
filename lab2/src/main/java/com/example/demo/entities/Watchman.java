package com.example.demo.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="watchmans")
final public class Watchman{
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private int salary;
    @Column
    private int cash;
    @Column
    private int bribeNeeded;
    @Id
    @GeneratedValue
    private UUID id;
    public Watchman(String name, String surname, int cash, int bribeNeeded, int salary){
        this.name = name;
        this.surname = surname;
        this.cash = cash;
        this.salary = salary;
        this.bribeNeeded = bribeNeeded;
    }

    public Watchman() {
    }

    public void monthSalary(){
        this.cash += this.salary;
    }

    public int getBribeNeeded(){
        return this.bribeNeeded;
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

    public void setBribeNeeded(int bribeNeeded) {
        this.bribeNeeded = bribeNeeded;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
