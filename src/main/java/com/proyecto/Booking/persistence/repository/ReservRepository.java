package com.proyecto.Booking.persistence.repository;

import com.proyecto.Booking.persistence.entities.Cls;
import com.proyecto.Booking.persistence.entities.Reserv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservRepository  extends JpaRepository<Reserv, Long> {
}
