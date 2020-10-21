package com.example.demo.entities.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "dorms")
final public class DormDto {
    private int dormNumber;
    private int cleanliness;
    private int numOfFreeRooms;
    private int monthPrice;
    private int income = 0;
    @Id
    @GeneratedValue
    private UUID id;

    public DormDto(int dormNumber, int cleanliness, int numOfRooms, int monthPrice ){
        this.dormNumber = dormNumber;
        this.cleanliness = cleanliness;
        this.numOfFreeRooms = numOfRooms;
        this.monthPrice = monthPrice;
    }

    public DormDto() { }

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

    public UUID getId(){return this.id;}
}