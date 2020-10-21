package com.example.demo.entities.dto;

public class PersonDto {
    private final String name;
    private final String surname;
    private final int salary;
    private int cash;

    public PersonDto(String name, String surname, int cash, int salary){
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

    public String getName (){return this.name;}

    public String getSurname(){return this.surname;}
}