package com.proyecto.Booking.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Membership")
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name= "usr_id",nullable = false)
    private Usr usr;
    @ManyToOne
    @JoinColumn(name= "MemberType_id",nullable = false)
    private MemberType memberType;


    public Membership(Long id, Usr usr, MemberType memberType) {
        this.id = id;
        this.usr = usr;
        this.memberType = memberType;
    }
    public Membership(){};

    //GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usr getUsr() {
        return usr;
    }

    public void setUsr(Usr usr) {
        this.usr = usr;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }
}
