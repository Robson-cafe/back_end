package com.robson.back_end.model;

import javax.persistence.Entity;

//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.*;

import java.util.Set;

@Entity (name = "BOX")

public class Box {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "box_id")
    Long id;
    String name;

    int capacity;
    String create_by;

    @OneToMany(targetEntity = Team.class, cascade = CascadeType.ALL, mappedBy = "box")
    Set<Team> teams;

    public Box(Long id, String name, int capacity, String create_by, Set<Team> teams) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.create_by = create_by;
        this.teams = teams;
    }

    public Box()
    {
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }
}
