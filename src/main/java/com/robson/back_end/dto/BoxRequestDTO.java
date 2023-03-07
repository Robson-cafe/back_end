package com.robson.back_end.dto;

import com.robson.back_end.model.Box;
import com.robson.back_end.model.Client;

public class BoxRequestDTO {
    String name;
    int capacity;

    public BoxRequestDTO(String name, int capacity, String create_by) {
        this.name = name;
        this.capacity = capacity;
    }

    public BoxRequestDTO() {
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
