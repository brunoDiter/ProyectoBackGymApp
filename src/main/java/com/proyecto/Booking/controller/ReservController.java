package com.proyecto.Booking.controller;

import com.proyecto.Booking.persistence.entities.Reserv;
import com.proyecto.Booking.service.ReservService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservController {

    @Autowired
    ReservService reservService;

    @GetMapping()
    public ResponseEntity<List<Reserv>> getAll(){return ResponseEntity.ok(reservService.getAll());}

    @GetMapping("/{id}")
    public ResponseEntity<Reserv> getOneById(@RequestBody Long id){return ResponseEntity.ok(reservService.getOneById(id));}

    @PostMapping()
    public void createReserv(@RequestBody Reserv reserv){reservService.createReserv(reserv);}

    @PutMapping("/{id}")
    public void editReserv(@RequestBody Reserv reserv) {reservService.editReserv(reserv);}

    @DeleteMapping("/{id}")
    public void deleteReserv(@RequestBody Reserv reserv) {reservService.deleteReserv(reserv);}

}
