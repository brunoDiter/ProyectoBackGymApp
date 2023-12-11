package com.proyecto.Booking.controller;

import com.proyecto.Booking.persistence.entities.Usr;
import com.proyecto.Booking.service.UsrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsrController {

    @Autowired
    UsrService usrService;

    @GetMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Usr>> getAll(){return ResponseEntity.ok(usrService.getAll());}

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Usr> getOneById(@RequestBody Long id){return ResponseEntity.ok(usrService.getOneById(id));}

    @PostMapping()
    public ResponseEntity<String> createUser(@RequestBody Usr usr){
        try {

            usrService.createUser(usr) ;

            return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");

    }   catch (Exception e){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating user");
        }
    }

    @PutMapping("/{id}")
    public void editUser(@PathVariable Long id, @RequestBody Usr usr) {usrService.editUser(id,usr);}

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(@RequestBody Usr usr) {usrService.deleteUser(usr);}


}