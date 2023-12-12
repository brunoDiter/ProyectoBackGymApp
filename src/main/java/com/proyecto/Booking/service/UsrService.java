
package com.proyecto.Booking.service;

import com.proyecto.Booking.persistence.dtos.AuthenticationRequest;
import com.proyecto.Booking.persistence.entities.Usr;
import com.proyecto.Booking.persistence.repository.UsrRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UsrService {
    @Autowired
    UsrRepository usrRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    public List<Usr> getAll(){return  usrRepository.findAll();}

    public Usr getOneById(Long id) {return usrRepository.findById(id).orElse(null);}

    public void createUser(Usr usr) {

            usr.setPassword(passwordEncoder.encode(usr.getPassword()));

            usrRepository.save(usr);
    }

    public void editUser(Long id,Usr usr) {

        Usr existingUser = usrRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("User no existe."));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        System.out.println("el currentUsername es " + currentUsername);

        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        System.out.println("Roles del usuario autenticado: " + authorities);

        boolean isSameUser = currentUsername.equals(existingUser.getEmail());
        System.out.println("el getEmail es " + existingUser.getEmail());

        if(isAdmin || isSameUser){
            existingUser.setEmail(usr.getEmail());
            existingUser.setMembership(usr.getMembership());
            existingUser.setTel(usr.getTel());
            existingUser.setFirstName(usr.getFirstName());
            existingUser.setLastName(usr.getLastName());
            existingUser.setDni(usr.getDni());

            if(isSameUser){
                String newPassword = usr.getPassword();
                if (newPassword != null && !newPassword.isEmpty()){
                    existingUser.setPassword(passwordEncoder.encode(newPassword));
                }
            }

            if(!isAdmin){

                existingUser.setRoles(existingUser.getRoles());
            } else {
                existingUser.setRoles(usr.getRoles());
            }

            usrRepository.save(existingUser);

        }else {

            throw new AccessDeniedException("Acceso denegado para editar el usuario");
        }

    }

    public void deleteUser(Long userId) {

        if(usrRepository.existsById(userId)){

            usrRepository.deleteById(userId);

        }else {

            throw new RuntimeException("No existe el usuario con el id " + userId +".");}

        }



}
