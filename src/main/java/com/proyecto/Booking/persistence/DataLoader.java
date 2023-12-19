package com.proyecto.Booking.persistence;

import com.proyecto.Booking.persistence.entities.RoleEntity;
import com.proyecto.Booking.persistence.repository.RoleRepository;
import com.proyecto.Booking.util.Role;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    @Autowired
    private final RoleRepository roleRepository;

    @Autowired
    public DataLoader(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void init() {
        initializeRoles();
    }

    private void initializeRoles() {
        for (Role role : Role.values()) {
            if (roleRepository.findByName(role).isEmpty()) {
                RoleEntity roleEntity = new RoleEntity();
                roleEntity.setName(role);
                roleRepository.save(roleEntity);
            }
        }
    }
}
