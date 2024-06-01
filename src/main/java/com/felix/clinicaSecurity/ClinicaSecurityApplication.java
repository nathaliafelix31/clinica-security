package com.felix.clinicaSecurity;

import com.felix.clinicaSecurity.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicaSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicaSecurityApplication.class, args);
	}
	@Autowired
	EmailService service;



}
