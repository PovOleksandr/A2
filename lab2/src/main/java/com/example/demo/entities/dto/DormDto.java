package com.example.demo.entities.dto;

import java.util.UUID;

final public class DormDto {
    private int dormNumber;
    private int cleanliness;
    private int numOfFreeRooms;
    private int monthPrice;
    private int income = 0;
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

    public UUID getId(){return this.id; }

    @Override
    public String toString() {
        return "DormDto{" +
                "dormNumber=" + dormNumber +
                ", cleanliness=" + cleanliness +
                ", numOfFreeRooms=" + numOfFreeRooms +
                ", monthPrice=" + monthPrice +
                ", income=" + income +
                ", id=" + id +
                '}';
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

    public void setId(UUID id) {
        this.id = id;
    }
}