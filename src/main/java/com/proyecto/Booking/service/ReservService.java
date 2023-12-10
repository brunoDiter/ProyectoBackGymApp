package com.proyecto.Booking.service;

import com.proyecto.Booking.persistence.entities.Reserv;
import com.proyecto.Booking.persistence.repository.ReservRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservService {

    @Autowired
    ReservRepository reservRepository;

    public List<Reserv> getAll(){return  reservRepository.findAll();}

    public Reserv getOneById(Long id) {return reservRepository.findById(id).orElse(null);}

    //Agregar verificacion de crear si no existe uno igual
    public void createReserv(Reserv reserv) {reservRepository.save(reserv);}


    public void editReserv(Reserv reserv) {

        if(reservExist(reserv.getId())){
            reservRepository.save(reserv);
        }else {
            throw new RuntimeException("La reserva no existe!");
        }
    }

    public void deleteReserv(Reserv reserv) {

        if(reservExist(reserv.getId())){
            reservRepository.delete(reserv);
        }else {
            throw new RuntimeException("No existe la reserva.");
        }
    }

    public boolean reservExist(Long reservId){
        Optional<Reserv> existingReserv = reservRepository.findById(reservId);
        return existingReserv.isPresent();
    }
    
}
