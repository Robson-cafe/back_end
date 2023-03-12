package com.robson.back_end.dto;

import com.robson.back_end.model.Box;

import java.util.Set;
import java.util.stream.Collectors;

public class BoxResponseDTO {
    String name;
    int capacity;
    String create_by;

    Set<Long> teams;

    public BoxResponseDTO(String name, int capacity, String create_by, Set<Long> teams) {
        this.name = name;
        this.capacity = capacity;
        this.create_by = create_by;
        this.teams = teams;
    }

    public BoxResponseDTO()
    {
    }
    public BoxResponseDTO(Box box) {
        name = box.getName();
        capacity = box.getCapacity();
        create_by = box.getCreate_by();
        teams = box.getTeams().stream().map(team -> team.getId()).collect(Collectors.toSet());
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public Set<Long> getTeams() {
        return teams;
    }

    public void setTeams(Set<Long> teams) {
        this.teams = teams;
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
}
