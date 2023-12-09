package com.proyecto.Booking.controller;

import com.proyecto.Booking.persistence.dtos.AuthenticationRequest;
import com.proyecto.Booking.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
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
        public String createAuthenticationToken (@RequestBody AuthenticationRequest authRequest) {

                return jwtUtil.createToken(authRequest.getEmail());
        }
    }


