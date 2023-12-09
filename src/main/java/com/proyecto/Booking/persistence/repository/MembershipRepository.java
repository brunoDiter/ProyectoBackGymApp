package com.proyecto.Booking.persistence.repository;

import com.proyecto.Booking.persistence.entities.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepository extends JpaRepository<Membership,Long> {}
