package com.proyecto.Booking.service;

import com.proyecto.Booking.persistence.entities.Cls;
import com.proyecto.Booking.persistence.entities.MemberType;
import com.proyecto.Booking.persistence.repository.MemberTypeRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public void editMemberType(Long id, MemberType memberType) {


        MemberType existingMemberType = memberTypeRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("La membresia no existe."));

        existingMemberType.setName(memberType.getName());
        existingMemberType.setDays(memberType.getDays());
        existingMemberType.setDescription(memberType.getDescription());
        existingMemberType.setPrice(memberType.getPrice());

        memberTypeRepository.save(memberType);
    }
    public void deleteMemberType(Long id) {

        if(memberTypeRepository.existsById(id)){

            memberTypeRepository.deleteById(id);

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
