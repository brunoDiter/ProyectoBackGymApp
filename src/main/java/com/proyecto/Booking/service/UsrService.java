
package com.proyecto.Booking.service;

import com.proyecto.Booking.persistence.entities.Book;
import com.proyecto.Booking.persistence.entities.LoginDto;
import com.proyecto.Booking.persistence.entities.Usr;
import com.proyecto.Booking.persistence.repository.UsrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsrService {
    @Autowired
    UsrRepository usrRepository;

    public boolean userLogin(LoginDto usr) {

        //usrRepository.findOne(usr.getEmail());

        //System.out.println("Que onda");

        return true;
    }


    public void guardarUsr(Usr usr){
        usrRepository.save(usr);
    }
    public List<Usr> retornarTodosLosUsrs(){
        return  usrRepository.findAll();
    }
}
