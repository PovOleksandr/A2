package com.example.demo.entities.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;


final public class JanitorDto extends PersonDto{
    private int cleaningQuality;
    @Id
    @GeneratedValue
    private UUID id;

    public JanitorDto( String name, String surname, int cash, int salary, int cleaningQuality){
        super( name, surname, cash, salary);
        this.cleaningQuality = cleaningQuality;
    }

    public JanitorDto() {
        super("Ivan","Ivanov",0,0);
    }

    public int getCleaningQuality(){
        return this.cleaningQuality;
    }

    public UUID getId(){return this.id;}

}