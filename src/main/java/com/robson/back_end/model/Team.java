package com.robson.back_end.model;

import javax.persistence.*;

import java.util.Set;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    // professor responsavel
    //aluno matricula
    @ManyToMany(targetEntity = Student.class,
                cascade = CascadeType.ALL,
                mappedBy = "teams"
    )
    Set<Student> students;

    @Column(name = "schedule")
    String schedule; // TODO: mudar para dayosweek end local time
    // 35_19 : terça e quinta as 19
    // 246_19 : segunda quarta e sexta as 17

    @ManyToOne(targetEntity = Box.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "box_id")
    Box box;

    public Team(Long id, Set<Student> students, String schedule, Box box) {
        this.id = id;
        this.students = students;
        this.schedule = schedule;
        this.box = box;
    }

    public Team() {
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
    }
}
