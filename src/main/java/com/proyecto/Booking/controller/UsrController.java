package com.proyecto.Booking.controller;

import com.proyecto.Booking.persistence.entities.Book;
import com.proyecto.Booking.persistence.entities.LoginDto;
import com.proyecto.Booking.persistence.entities.Usr;
import com.proyecto.Booking.service.UsrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UsrController {

    @Autowired
    UsrService usrService;

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody LoginDto usr){

        return ResponseEntity.ok(usrService.userLogin(usr));

    }

    @PostMapping("/crear")
    public void crear(@RequestBody Usr usr){

        usrService.guardarUsr(usr);
    }

    @GetMapping("/traertodoslosuser")
    public ResponseEntity<List<Usr>> traertodos(){

        return ResponseEntity.ok(usrService.retornarTodosLosUsrs());
    }


}