package com.castelli.acervo;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.castelli.acervo.domain.Artista;
import com.castelli.acervo.domain.Funcao;
import com.castelli.acervo.repositories.ArtistaRepository;
import com.castelli.acervo.repositories.FuncaoRepository;

@SpringBootApplication
public class AcervoApplication implements CommandLineRunner {

	@Autowired
	private FuncaoRepository funcaoRepository;
	@Autowired
	private ArtistaRepository artistaRepository;

	public static void main(String[] args) {
		SpringApplication.run(AcervoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Funcao f1 = new Funcao(null, "Compositor");
		Funcao f2 = new Funcao(null, "Cantor");
		Artista a1 = new Artista(null, "Beethoven", "Ludwig van Beethoven", 1770, 1827);
		Artista a2 = new Artista(null, "Tchaikovski", "Piotr Ilitch Tchaikovski", 1840, 1893);
		Artista a3 = new Artista(null, "Mozart", "Wolfgang Amadeus Mozart ", 1756, 1791);
		Artista a4 = new Artista(null, "Mussorgsky", "Modest Petrovich Mussorgsky", 1839, 1881);
		Artista a5 = new Artista(null, "Chopin", "Frédéric François Chopin", 1810, 1849);
		Artista a6 = new Artista(null, "Bach", "Johann Sebastian Bach", 1685, 1750);
		Artista a7 = new Artista(null, "Pixinguinha", "Alfredo da Rocha Vianna Filho", 1897, 1973);
		Artista a8 = new Artista(null, "Cândido das Neves", "Cândido das Neves", 1899, 1934);
		Artista a9 = new Artista(null, "Benedito Lacerda", "Benedicto Lacerda", 1903, 1958);
		f1.getArtistas().addAll(Arrays.asList(a1, a2, a3, a4, a5, a6, a7, a8, a9));
		f2.getArtistas().addAll(Arrays.asList(a7, a9));
		a1.getFuncoes().addAll(Arrays.asList(f1));
		a2.getFuncoes().addAll(Arrays.asList(f1));
		a3.getFuncoes().addAll(Arrays.asList(f1));
		a4.getFuncoes().addAll(Arrays.asList(f1));
		a5.getFuncoes().addAll(Arrays.asList(f1));
		a6.getFuncoes().addAll(Arrays.asList(f1));
		a7.getFuncoes().addAll(Arrays.asList(f1, f2));
		a8.getFuncoes().addAll(Arrays.asList(f1));
		a9.getFuncoes().addAll(Arrays.asList(f1, f2));
		funcaoRepository.saveAll(Arrays.asList(f1, f2));
		artistaRepository.saveAll(Arrays.asList(a1, a2, a3, a4, a5, a6, a7, a8, a9));
	}
}
