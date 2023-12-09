package com.proyecto.Booking.controller;

import com.proyecto.Booking.persistence.entities.Cls;
import com.proyecto.Booking.persistence.entities.Usr;
import com.proyecto.Booking.service.ClsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Cls> getOneById(@RequestBody Long id){return ResponseEntity.ok(clsService.getOneById(id));}

    @PostMapping()
    public void createCls(@RequestBody Cls cls){clsService.createCls(cls);}

    @PutMapping("/{id}")
    public void editCls(@RequestBody Cls cls) {clsService.editCls(cls);}

    @DeleteMapping("/{id}")
    public void deleteCls(@RequestBody Cls cls) {clsService.deleteCls(cls);}


}