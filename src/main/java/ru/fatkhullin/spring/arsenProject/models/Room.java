package ru.fatkhullin.spring.arsenProject.models;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Room")
public class Room {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "roomnumber")
    private int roomnumber;

    @Column(name = "countplace")
    private int countplace;

    @OneToMany(mappedBy = "room",
    fetch = FetchType.LAZY)
    private List<Person> persons;

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public Room() {
    }

    public Room(int id, int roomnumber, int countplace) {
        this.id = id;
        this.roomnumber = roomnumber;
        this.countplace = countplace;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(int roomnumber) {
        this.roomnumber = roomnumber;
    }

    public int getCountplace() {
        return countplace;
    }

    public void setCountplace(int countplace) {
        this.countplace = countplace;
    }
}
