package com.proyecto.Booking.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Reservation")

public class Reserv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @ManyToOne
    @JoinColumn(name = "usr_id", nullable = false)
    private Usr usr;
    @ManyToOne
    @JoinColumn(name = "cls_id", nullable = false)
    private Cls cls;

    public Reserv(){}

    public Reserv(Usr usr, Cls cls){
        this.usr=usr;
        this.cls=cls;
    }

}
