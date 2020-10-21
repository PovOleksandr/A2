package com.example.demo.entities;


import javax.persistence.Column;


public class Person {
    @Column
    private final String name;
    @Column
    private final String surname;
    @Column
    private final int salary;
    @Column
    private int cash;

    public Person(String name, String surname, int cash, int salary){
        this.name = name;
        this.surname = surname;
        this.cash = cash;
        this.salary = salary;
    }

    public void monthSalary(){
        this.cash += this.salary;
    }

    public int getSalary(){return this.salary;}

    public int getCash(){
        return this.cash;
    }

    public void setCash(int amount){
        this.cash += amount;
    }


}
