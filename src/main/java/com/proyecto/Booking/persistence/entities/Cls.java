package com.proyecto.Booking.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Cls {

    //Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private String name;
    @Column
    private String schedule;
    @Column
    private Boolean disponibility;
    @Column
    private String description;
    @OneToOne
    @JoinColumn(name = "usr_id")
    private Usr usr;


    //Method


    public Usr getUsr() {
        return usr;
    }

    public void setUsr(Usr usr) {
        this.usr = usr;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getNameCls() {
        return name;
    }

    public void setNameCls(String nameCls) {
        this.name = nameCls;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public Boolean getDisponibility() {
        return disponibility;
    }

    public void setDisponibiliy(Boolean disponibility) {
        this.disponibility = disponibility;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Cls(String name, String schedule, Boolean disponibility, String description, Usr usr) {
        this.name = name;
        this.schedule = schedule;
        this.disponibility = disponibility;
        this.description = description;
        this.usr = usr;
    }
}
