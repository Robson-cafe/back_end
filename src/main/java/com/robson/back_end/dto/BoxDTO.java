package com.robson.back_end.dto;

public class BoxDTO {
    String name;
    String capacity;

    public BoxDTO(
        String name,
        String capacity
    )
    {
        this.name = name;
        this.capacity = capacity;
    }

    public BoxDTO()
    {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
}
