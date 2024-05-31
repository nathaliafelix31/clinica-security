package com.felix.clinicaSecurity;

import com.felix.clinicaSecurity.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ClinicaSecurityApplication implements CommandLineRunner {

	public static void main(String[] args) {
		//System.out.println(new BCryptPasswordEncoder().encode("123456"));
		SpringApplication.run(ClinicaSecurityApplication.class, args);
	}
	@Autowired
	EmailService service;

	@Override
	public void run(String... args) throws Exception {
		service.enviarPedidoDeConfirmacaoDeCadastro("nathy.felix.31@gmail.com", "9852pol");
	}

}
