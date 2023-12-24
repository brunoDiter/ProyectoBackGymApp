package com.proyecto.Booking.service;

import com.proyecto.Booking.persistence.entities.Cls;
import com.proyecto.Booking.persistence.entities.Usr;
import com.proyecto.Booking.persistence.repository.ClsRepository;
import com.proyecto.Booking.persistence.repository.UsrRepository;
import com.proyecto.Booking.util.Role;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClsService {
    @Autowired
    ClsRepository clsRepository;

    @Autowired
    UsrRepository usrRepository;


    public List<Cls> getAll() {
        return clsRepository.findAll();
    }

    public Cls getOneById(Long id) {
        return clsRepository.findById(id).orElse(null);
    }

    public void createCls(Cls cls) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Roles del usuario autenticado: " + authentication.getAuthorities());

        clsRepository.save(cls);
    }

    public void editCls(Long id, Cls cls) {

        Cls existingClass = clsRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("La clase no existe."));

        Usr assignedProfessor = cls.getUsr();
        Usr beProfessor = usrRepository.findById(assignedProfessor.getUser_id())
                .orElseThrow(() -> new EntityNotFoundException("El profesor no existe."));

        if (beProfessor != null) {

            if (!isProfessor()) {
                throw new AccessDeniedException("No tiene permisos para asignar un profesor a la clase.");
            }

            if (isUserRoleProfessor(beProfessor) && isUserAdmin()) {
                throw new IllegalArgumentException("El usuario asignado no tiene el rol de PROFESSOR.");
            }

            existingClass.setUsr(beProfessor);
        } else {
            existingClass.setUsr(null);
        }

        existingClass.setNameCls(cls.getNameCls());
        existingClass.setSchedule(cls.getSchedule());
        existingClass.setDescription(cls.getDescription());
        existingClass.setDisponibiliy(cls.getDisponibility());

        clsRepository.save(existingClass);
    }

    public void deleteCls(Long id) {

        if (clsRepository.existsById(id)) {

            clsRepository.deleteById(id);

        } else {
            throw new RuntimeException("No existe el usuario con el id " + id + ".");
        }
    }


    private boolean isProfessor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority ->
                        grantedAuthority.getAuthority().equals("ROLE_PROFESSOR") ||
                                grantedAuthority.getAuthority().equals("ROLE_ADMIN"));
    }

    private boolean isUserRoleProfessor(Usr user) {
        // Verificar si el usuario tiene el rol de "PROFESSOR"
        return user.getRoles().stream()
                .anyMatch(role -> role.getName().equals(Role.PROFESSOR));
    }

    private boolean isUserAdmin() {
        // Verificar si el usuario autenticado tiene el rol "ADMIN"
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));
    }

}
