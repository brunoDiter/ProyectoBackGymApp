package com.proyecto.Booking.configuration;

import com.proyecto.Booking.persistence.entities.Usr;
import com.proyecto.Booking.persistence.repository.UsrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

        @Autowired
        private UsrRepository usrRepository;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

            Usr usr = usrRepository.findByEmail(username)
                    .orElseThrow(()-> new UsernameNotFoundException("User not found"+ username));

                Collection<? extends GrantedAuthority> authorities = usr.getRoles()
                        .stream()
                        .map(role-> new SimpleGrantedAuthority("ROLE_".concat(role.getName().name())))
                        .collect(Collectors.toSet());

                return new User(usr.getEmail(),
                        usr.getPassword(),
                        true,
                        true,
                        true,
                        true,
                        authorities);

            }
        }
