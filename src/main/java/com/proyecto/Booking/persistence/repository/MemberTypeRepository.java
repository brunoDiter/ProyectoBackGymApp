package com.proyecto.Booking.persistence.repository;

import com.proyecto.Booking.persistence.entities.MemberType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberTypeRepository extends JpaRepository<MemberType, Long> {
}
