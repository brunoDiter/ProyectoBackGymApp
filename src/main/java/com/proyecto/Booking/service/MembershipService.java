package com.proyecto.Booking.service;

import com.proyecto.Booking.persistence.entities.Membership;
import com.proyecto.Booking.persistence.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembershipService {

    @Autowired
    MembershipRepository membershipRepository;


    public Membership getOneById(Long id) {return membershipRepository.findById(id).orElse(null);}

    public void createEstateMembership(Membership membership) {membershipRepository.save(membership);}

    public void editEstateMembership(Membership membership) {membershipRepository.save(membership);}

}
