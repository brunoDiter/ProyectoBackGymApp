package com.proyecto.Booking.persistence.repository;

import com.proyecto.Booking.persistence.entities.Usr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsrRepository extends JpaRepository<Usr, Long> {

    Optional<Usr> findByEmail(String email);
}
