package com.example.demo.entities.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name="watchmans")
final public class WatchmanDto extends PersonDto{
    private int bribeNeeded;
    @Id
    @GeneratedValue
    private UUID id;
    public WatchmanDto(String name, String surname, int cash, int bribeNeeded, int salary){
        super(name, surname, cash, salary);
        this.bribeNeeded = bribeNeeded;
    }

    public WatchmanDto() {
        super("Ivan","Ivanov",0,0);
    }

    public int getBribeNeeded(){
        return this.bribeNeeded;
    }

    public UUID getId(){return this.id;}
}
