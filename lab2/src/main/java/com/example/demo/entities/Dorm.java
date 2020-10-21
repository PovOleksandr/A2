package com.example.demo.entities;

import javax.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "dorms")
public class Dorm {
    @Id
    @GeneratedValue
    private UUID id;

    private int dormNumber;

    private int cleanliness;

    private int numOfFreeRooms;

    private int monthPrice;

    private int income = 0;

    public Dorm(int dormNumber,int cleanliness, int numOfRooms, int monthPrice ){
        this.dormNumber = dormNumber;
        this.cleanliness = cleanliness;
        this.numOfFreeRooms = numOfRooms;
        this.monthPrice = monthPrice;
    }

    public Dorm() { }

    public int getNumOfFreeRooms(){return this.numOfFreeRooms;}

    public int getDormNumber(){return this.dormNumber;}

    public int getCleanliness(){
        return this.cleanliness;
    }

    public int getMonthPrice(){return this.monthPrice;}

    public void setCleanliness(int value){
        this.cleanliness += value;
    }

    public void changeRooms(int value){
        this.numOfFreeRooms += value;
    }

    public void increaceIncome( float value){ this.income += value; }

    public void setId(){this.id = UUID.randomUUID();}

    public UUID getId(){return this.id;}

    public void setId(UUID id) {
        this.id = id;
    }

    public void setDormNumber(int dormNumber) {
        this.dormNumber = dormNumber;
    }

    public void setNumOfFreeRooms(int numOfFreeRooms) {
        this.numOfFreeRooms = numOfFreeRooms;
    }

    public void setMonthPrice(int monthPrice) {
        this.monthPrice = monthPrice;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    @Override
    public String toString() {
        return "Dorm{" +
                "id=" + id +
                ", dormNumber=" + dormNumber +
                ", cleanliness=" + cleanliness +
                ", numOfFreeRooms=" + numOfFreeRooms +
                ", monthPrice=" + monthPrice +
                ", income=" + income +
                '}';
    }
}
