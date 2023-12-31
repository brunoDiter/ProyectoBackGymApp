package com.proyecto.Booking.persistence.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "MemberType")
public class MemberType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private String name;
    @Column
    private Integer price;
    @Column
    private Integer days;
    @Column
    private String description;
    @OneToMany(mappedBy = "memberType")
    private Set<Usr> users = new HashSet<>();

    //GETTERS AND SETTERS


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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Usr> getUsers() {
        return users;
    }

    public void setUsers(Set<Usr> users) {
        this.users = users;
    }

    public MemberType(Long id, String name, Integer price, Integer days, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.days = days;
        this.description = description;
    }
    public MemberType(){}
}
