package com.proyecto.Booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EntityScan(basePackages = "com.proyecto.Booking.persistence.entities")

public class BookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingApplication.class, args);
		// Obtiene la contraseña en texto claro desde la base de datos
		String plaintextPassword = "4610399";

		// Crea un encoder BCrypt
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		// Encripta la contraseña
		String hashedPassword = passwordEncoder.encode(plaintextPassword);

		// Imprime la contraseña encriptada
		System.out.println("Contraseña encriptada: " + hashedPassword);
	}


}
