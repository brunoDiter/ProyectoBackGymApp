package com.proyecto.Booking.service;

import com.proyecto.Booking.persistence.entities.Cls;
import com.proyecto.Booking.persistence.entities.Usr;
import com.proyecto.Booking.persistence.repository.ClsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClsService {
    @Autowired
    ClsRepository clsRepository;


    public List<Cls> getAll(){return  clsRepository.findAll();}

    public Cls getOneById(Long id) {return clsRepository.findById(id).orElse(null);}

    //Agregar verificacion de crear si no existe uno igual
    public void createCls(Cls cls) {clsRepository.save(cls);}

    public void editCls(Long id, Cls cls) {

        Cls existingClass = clsRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("La clase no existe."));

        existingClass.setNameCls(cls.getNameCls());
        existingClass.setSchedule(cls.getSchedule());
        existingClass.setDescription(cls.getDescription());
        existingClass.setDisponibiliy(cls.getDisponibility());

        clsRepository.save(existingClass);}

    //Agregar verificacion de eliminar solo si existe
    public void deleteCls(Long id) {

        if(clsRepository.existsById(id)){

            clsRepository.deleteById(id);

        }else {
            throw new RuntimeException("No existe el usuario con el id " + id +".");}
        }
    }
