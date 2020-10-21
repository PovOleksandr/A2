package com.example.demo.entities;

import javax.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "dorms")
final public class Dorm {
    @Column
    private int dormNumber;
    @Column
    private int cleanliness;
    @Column
    private int numOfFreeRooms;
    @Column
    private int monthPrice;
    @Column
    private int income = 0;
    @Id
    @GeneratedValue
    private UUID id;

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
}
