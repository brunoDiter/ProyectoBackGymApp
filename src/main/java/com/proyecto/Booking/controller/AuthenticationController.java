package com.proyecto.Booking.controller;

import com.proyecto.Booking.persistence.dtos.AuthenticationRequest;
import com.proyecto.Booking.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class AuthenticationController {
        @Autowired
        private UserDetailsService userDetailsService;
        @Autowired
        private JwtUtil jwtUtil;

        @Autowired
        private AuthenticationManager authenticationManager;


        @GetMapping("/public-access")
        public String publicAccesEndpoint(){return "Este Endpoint es publico";}


        @PostMapping("/login")
        public ResponseEntity<?> createAuthenticationToken (@RequestBody AuthenticationRequest authRequest) {

                try {
                        String token = jwtUtil.createToken(authRequest.getEmail());

                        return ResponseEntity.ok().body(token);

                }catch (AuthenticationException e){

                        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o contraseña incorrecta.");
                }
        }

    }


