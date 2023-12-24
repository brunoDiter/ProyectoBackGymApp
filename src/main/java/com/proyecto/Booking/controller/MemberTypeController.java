package com.proyecto.Booking.controller;

import com.proyecto.Booking.persistence.entities.Cls;
import com.proyecto.Booking.persistence.entities.MemberType;
import com.proyecto.Booking.persistence.repository.MemberTypeRepository;
import com.proyecto.Booking.service.ClsService;
import com.proyecto.Booking.service.MemberTypeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/membershipType")
public class MemberTypeController {

    @Autowired
    MemberTypeService memberTypeService;


    @GetMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<MemberType>> getAll(){return ResponseEntity.ok(memberTypeService.getAll());}

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MemberType> getOneById(@PathVariable Long id){return ResponseEntity.ok(memberTypeService.getOneById(id));}

    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> createMemberType(@RequestBody MemberType memberType){

        try {

            memberTypeService.createMemberType(memberType); ;

            return ResponseEntity.status(HttpStatus.CREATED).body("MemberType created successfully");

        }   catch (Exception e){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating memberType");
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String>  editMemberType(@PathVariable Long id, @RequestBody MemberType memberType) {

        try {
            memberTypeService.editMemberType(id, memberType);
            return ResponseEntity.ok("MemberType modificado correctamente");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el tipo de membresia con el ID " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al intentar modificar el tipo de membresia");
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteMemberType(@PathVariable Long id) {

        try {
            memberTypeService.deleteMemberType(id);
            return ResponseEntity.ok("Tipo de membresia  eliminado correctamente");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el tipo de membresia con el ID " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al intentar eliminar el tipo de membresia");
        }
    }
}
