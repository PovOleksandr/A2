package com.example.demo.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "janitors")
final public class Janitor extends Person{
    @Column
    private int cleaningQuality;
    @Id
    @GeneratedValue
    private UUID id;

    public Janitor( String name, String surname, int cash, int salary, int cleaningQuality){
        super( name, surname, cash, salary);
        this.cleaningQuality = cleaningQuality;
    }

    public Janitor() {
        super("Ivan","Ivanov",0,0);
    }

    public int getCleaningQuality(){
        return this.cleaningQuality;
    }

    public void addId(){this.id = UUID.randomUUID();}

}
