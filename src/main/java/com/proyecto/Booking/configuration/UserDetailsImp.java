package com.proyecto.Booking.configuration;

import com.proyecto.Booking.persistence.entities.Usr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserDetailsImp implements UserDetails {

    private String name;
    private String password;
    private String role;
    @Autowired
    private Usr usr;


    public UserDetailsImp(Usr usr){
        name = usr.getEmail();
        password= usr.getPassword();
        role = usr.getRoles().toString();

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authorities = usr.getRoles().stream()
                .map(PermissionEnum -> new SimpleGrantedAuthority(PermissionEnum.getName().name()))
                .collect(Collectors.toList());

        authorities.add(new SimpleGrantedAuthority("ROLE_"+ role)); //Agrego a ROLE como Authorities.

        return authorities;
    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
