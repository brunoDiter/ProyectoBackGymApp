package com.proyecto.Booking.controller;

import com.proyecto.Booking.persistence.entities.Cls;
import com.proyecto.Booking.persistence.entities.MemberType;
import com.proyecto.Booking.persistence.repository.MemberTypeRepository;
import com.proyecto.Booking.service.ClsService;
import com.proyecto.Booking.service.MemberTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/membershipType")
public class MemberTypeController {

    @Autowired
    MemberTypeService memberTypeService;


    @GetMapping()
    public ResponseEntity<List<MemberType>> getAll(){return ResponseEntity.ok(memberTypeService.getAll());}

    @GetMapping("/{id}")
    public ResponseEntity<MemberType> getOneById(@RequestBody Long id){return ResponseEntity.ok(memberTypeService.getOneById(id));}

    @PostMapping()
    public void createMemberType(@RequestBody MemberType memberType){memberTypeService.createMemberType(memberType);}

    @PutMapping("/{id}")
    public void editMemberType(@RequestBody MemberType memberType) {memberTypeService.editMemberType(memberType);}

    @DeleteMapping("/{id}")
    public void deleteMemberType(@RequestBody MemberType memberType) {memberTypeService.deleteMemberType(memberType);}
}
