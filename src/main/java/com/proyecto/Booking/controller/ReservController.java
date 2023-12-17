package com.proyecto.Booking.controller;

import com.proyecto.Booking.persistence.entities.Reserv;
import com.proyecto.Booking.service.ReservService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservController {

    @Autowired
    ReservService reservService;

    @GetMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Reserv>> getAll(){return ResponseEntity.ok(reservService.getAll());}

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Reserv> getOneById(@PathVariable Long id){return ResponseEntity.ok(reservService.getOneById(id));}

    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> createReserv(@RequestBody Reserv reserv){

        try {

            reservService.createReserv(reserv); ;

            return ResponseEntity.status(HttpStatus.CREATED).body("Reserv created successfully");

        }   catch (Exception e){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating reserv");
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> editReserv(@PathVariable Long id,@RequestBody Reserv reserv) {

        try {
            reservService.editReserv(id, reserv);
            return ResponseEntity.ok("Reserva modificada correctamente");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe la reserva con el ID " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al intentar modificar la membresia");
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteReserv(@PathVariable Long id) {

        try {
            reservService.deleteReserv(id);
            return ResponseEntity.ok("Reserva eliminada correctamente");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el usuario con el ID " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al intentar eliminar el usuario");
        }
    }

}
