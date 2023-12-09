
package com.proyecto.Booking.service;

import com.proyecto.Booking.persistence.dtos.AuthenticationRequest;
import com.proyecto.Booking.persistence.entities.Usr;
import com.proyecto.Booking.persistence.repository.UsrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsrService {
    @Autowired
    UsrRepository usrRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    public List<Usr> getAll(){return  usrRepository.findAll();}

    public Usr getOneById(Long id) {return usrRepository.findById(id).orElse(null);}

    //Agregar verificacion de crear si no existe uno igual
    public void createUser(Usr usr) {

            usr.setPassword(passwordEncoder.encode(usr.getPassword()));

            usrRepository.save(usr);
    }


    //Agregar verificacion para editar solo si existe
    public void editUser(Usr usr) {usrRepository.save(usr);}

    //Agregar verificacion de eliminar solo si existe
    public void deleteUser(Usr usr) {usrRepository.delete(usr);}


    public boolean userLogin(AuthenticationRequest usr) {

        //usrRepository.findOne(usr.getEmail());

        //System.out.println("Que onda");

        return true;
    }


}
