package com.proyecto.Booking.service;

import com.proyecto.Booking.persistence.entities.Cls;
import com.proyecto.Booking.persistence.entities.MemberType;
import com.proyecto.Booking.persistence.repository.MemberTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberTypeService {

    @Autowired
    MemberTypeRepository memberTypeRepository;

    public List<MemberType> getAll(){return  memberTypeRepository.findAll();}


    public MemberType getOneById(Long id) {return memberTypeRepository.findById(id).orElse(null);}

    //Agregar verificacion de crear si no existe uno igual
    public void createMemberType(MemberType memberType) {memberTypeRepository.save(memberType);}

    //Agregar verificacion para editar solo si existe
    public void editMemberType(MemberType memberType) {memberTypeRepository.save(memberType);}

    //Agregar verificacion de eliminar solo si existe
    public void deleteMemberType(MemberType memberType) {memberTypeRepository.delete(memberType);}
}
