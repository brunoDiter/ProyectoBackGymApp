package com.proyecto.Booking.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Membership")
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToOne
    @JoinColumn(name= "user_id")
    private Usr user_Id;
    @OneToOne
    @JoinColumn(name= "memberType_id")
    private MemberType Membertype_Id;


    public Membership(Long id, Usr user_Id, MemberType MemberType_id) {
        this.id = id;
        this.user_Id = user_Id;
        this.Membertype_Id = MemberType_id;
    }
    public Membership(){};

    //GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usr getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(Usr user_Id) {
        this.user_Id = user_Id;
    }

    public MemberType getType_Id() {
        return Membertype_Id;
    }

    public void setType_Id(MemberType type_Id) {
        this.Membertype_Id = type_Id;
    }


}
