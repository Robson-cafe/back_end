package com.robson.back_end.dto;

import com.robson.back_end.model.Box;

public class BoxResponseDTO {
    String name;
    int capacity;
    String create_by;

    public BoxResponseDTO(String name, int capacity, String create_by) {
        this.name = name;
        this.capacity = capacity;
        this.create_by = create_by;
    }

    public BoxResponseDTO()
    {
    }
    public BoxResponseDTO(Box box) {
        name = box.getName();
        capacity = box.getCapacity();
        create_by = box.getCreate_by();
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
