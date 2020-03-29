package com.castelli.acervo;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.castelli.acervo.domain.Funcao;
import com.castelli.acervo.repositories.FuncaoRepository;

@SpringBootApplication
public class AcervoApplication implements CommandLineRunner {

	@Autowired
	private FuncaoRepository funcaoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AcervoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Funcao f1 = new Funcao(null, "Compositor");
        Funcao f2 = new Funcao(null, "Cantor");
        funcaoRepository.saveAll(Arrays.asList(f1,f2));
	}
}
