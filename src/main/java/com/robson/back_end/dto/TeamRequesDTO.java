package com.robson.back_end.dto;

public class TeamRequesDTO {
    String schedule;
    Long  box_id;

    public TeamRequesDTO(String schedule, Long box_id) {
        this.schedule = schedule;
        this.box_id = box_id;
    }

    public TeamRequesDTO() {
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public Long getBox_id() {
        return box_id;
    }

    public void setBox_id(Long box_id) {
        this.box_id = box_id;
    }
}
