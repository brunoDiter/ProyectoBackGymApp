package com.proyecto.Booking.controller;

import com.proyecto.Booking.persistence.entities.Cls;
import com.proyecto.Booking.persistence.entities.Usr;
import com.proyecto.Booking.service.ClsService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClsController {

    @Autowired
    ClsService clsService;


    @GetMapping()
    public ResponseEntity<List<Cls>> getAll(){return ResponseEntity.ok(clsService.getAll());}

    @GetMapping("/{id}")
    public ResponseEntity<Cls> getOneById(@PathVariable Long id){return ResponseEntity.ok(clsService.getOneById(id));}

    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> createCls(@RequestBody Cls cls){

        try {

            clsService.createCls(cls); ;

            return ResponseEntity.status(HttpStatus.CREATED).body("Class created successfully");

        }   catch (Exception e){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating class");
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> editCls(@PathVariable Long id, @RequestBody Cls cls) {

        try {
            clsService.editCls(id, cls);
            return ResponseEntity.ok("Clase modificada correctamente");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe la clase con el ID " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al intentar editar la clase");
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteCls(@PathVariable Long id) {

        try {
            clsService.deleteCls(id);
            return ResponseEntity.ok("Clase eliminado correctamente");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe la clase con el ID " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al intentar eliminar el usuario");}
    }
}