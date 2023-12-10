package com.proyecto.Booking.persistence.repository;

import com.proyecto.Booking.persistence.entities.MemberType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberTypeRepository extends JpaRepository<MemberType, Long> {

    @Query("SELECT m FROM MemberType m WHERE m.name = :name")
    Optional<MemberType> findByName(@Param("name") String name);
}
