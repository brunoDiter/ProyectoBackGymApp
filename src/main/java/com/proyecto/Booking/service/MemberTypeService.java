package com.proyecto.Booking.service;

import com.proyecto.Booking.persistence.entities.Cls;
import com.proyecto.Booking.persistence.entities.MemberType;
import com.proyecto.Booking.persistence.repository.MemberTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberTypeService {

    @Autowired
    MemberTypeRepository memberTypeRepository;

    public List<MemberType> getAll(){return  memberTypeRepository.findAll();}


    public MemberType getOneById(Long id) {return memberTypeRepository.findById(id).orElse(null);}

    public void createMemberType(MemberType memberType) {

        if(!memberTypeExist(memberType.getName())){

            memberTypeRepository.save(memberType);
        }else {
            throw new RuntimeException("Membresia existente.");
        }
    }

    public void editMemberType(MemberType memberType) {

        if (memberTypeExist(memberType.getName())){

            memberTypeRepository.save(memberType);

        }else {
            throw new RuntimeException("La membresia no existe.");
        }
    }
    public void deleteMemberType(MemberType memberType) {

        if(memberTypeExist(memberType.getName())){

            memberTypeRepository.delete(memberType);

        }else {
            throw new RuntimeException("No existe el tipo de membresia.");
        }
    }

    private boolean memberTypeExist(String memberTypeName){
        Optional<MemberType> existingMemberType = memberTypeRepository
                .findByName(memberTypeName);
        return existingMemberType.isPresent();
    }
}
