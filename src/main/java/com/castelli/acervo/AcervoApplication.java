package com.castelli.acervo;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.castelli.acervo.domain.Pais;
import com.castelli.acervo.repositories.PaisRepository;

@SpringBootApplication
public class AcervoApplication implements CommandLineRunner {

	@Autowired
	private PaisRepository paisRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AcervoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Pais p1 = new Pais(null, "Alemanha");
		Pais p2 = new Pais(null, "Rússia");
		Pais p3 = new Pais(null, "Áustria");
		Pais p4 = new Pais(null, "Polônia");
		Pais p5 = new Pais(null, "Brasil");
		paisRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
	}
}
