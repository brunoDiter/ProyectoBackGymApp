package com.proyecto.Booking.controller;

import com.proyecto.Booking.persistence.entities.Membership;
import com.proyecto.Booking.persistence.entities.Reserv;
import com.proyecto.Booking.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/membership")
public class MembershipController {

    @Autowired
    MembershipService membershipService;

    @GetMapping("/{id}")
    public ResponseEntity<Membership> getOneById(@RequestBody Long id){return ResponseEntity.ok(membershipService.getOneById(id));}

    @PostMapping()
    public void createEstateMember(@RequestBody Membership membership){membershipService.createEstateMembership(membership);}

    @PutMapping("/{id}")
    public void editEstateMember(@RequestBody Membership membership) {membershipService.editEstateMembership(membership);}

}
