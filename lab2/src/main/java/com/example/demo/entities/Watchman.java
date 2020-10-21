package com.example.demo.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="watchmans")
final public class Watchman extends Person{
    @Column
    private int bribeNeeded;
    @Id
    @GeneratedValue
    private UUID id;
    public Watchman(String name, String surname, int cash, int bribeNeeded, int salary){
        super(name, surname, cash, salary);
        this.bribeNeeded = bribeNeeded;
    }

    public Watchman() {
        super("Ivan","Ivanov",0,0);
    }

    public int getBribeNeeded(){
        return this.bribeNeeded;
    }

    public void addId(){this.id = UUID.randomUUID();}
}
