package com.proyecto.Booking.persistence.repository;

import com.proyecto.Booking.persistence.entities.RoleEntity;

import com.proyecto.Booking.util.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
    Optional<RoleEntity> findByName(Role name);
}
