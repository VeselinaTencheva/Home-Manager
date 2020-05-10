package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long personid;
    //1 building
    @ManyToOne
    @JoinColumn(name = "building")
    private Building building;
    @Column(name = "name", nullable = false)
    private String personName;
    public Person() {
    }
    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Long getPersonid() {
        return personid;
    }

    public void setPersonid(Long personid) {
        this.personid = personid;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personid=" + personid +
                ", building=" + building +
                ", personName='" + personName + '\'' +
                '}';
    }
}

