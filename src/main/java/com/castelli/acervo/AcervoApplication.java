package com.castelli.acervo;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.castelli.acervo.domain.Artista;
import com.castelli.acervo.domain.Funcao;
import com.castelli.acervo.domain.Genero;
import com.castelli.acervo.domain.Musica;
import com.castelli.acervo.domain.MusicaArtistaFuncao;
import com.castelli.acervo.domain.Pais;
import com.castelli.acervo.repositories.ArtistaRepository;
import com.castelli.acervo.repositories.FuncaoRepository;
import com.castelli.acervo.repositories.GeneroRepository;
import com.castelli.acervo.repositories.MusicaArtistaFuncaoRepository;
import com.castelli.acervo.repositories.MusicaRepository;
import com.castelli.acervo.repositories.PaisRepository;

@SpringBootApplication
public class AcervoApplication implements CommandLineRunner {

	@Autowired
	private FuncaoRepository funcaoRepository;
	@Autowired
	private ArtistaRepository artistaRepository;
	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private GeneroRepository generoRepository;
	@Autowired
	private MusicaRepository musicaRepository;
	@Autowired
	private MusicaArtistaFuncaoRepository musicaArtistaFuncaoRepository;

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
		Pais p6 = new Pais(null, "indefinido");
		Funcao f1 = new Funcao(null, "Compositor");
		Funcao f2 = new Funcao(null, "Cantor");
		Artista a1 = new Artista(null, "Beethoven", "Ludwig van Beethoven", 1770, 1827, p1);
		Artista a2 = new Artista(null, "Tchaikovski", "Piotr Ilitch Tchaikovski", 1840, 1893, p2);
		Artista a3 = new Artista(null, "Mozart", "Wolfgang Amadeus Mozart ", 1756, 1791, p3);
		Artista a4 = new Artista(null, "Mussorgsky", "Modest Petrovich Mussorgsky", 1839, 1881, p2);
		Artista a5 = new Artista(null, "Chopin", "Frédéric François Chopin", 1810, 1849, p4);
		Artista a6 = new Artista(null, "Bach", "Johann Sebastian Bach", 1685, 1750, p1);
		Artista a7 = new Artista(null, "Pixinguinha", "Alfredo da Rocha Vianna Filho", 1897, 1973,p5);
		Artista a8 = new Artista(null, "Cândido das Neves", "Cândido das Neves", 1899, 1934, p5);
		Artista a9 = new Artista(null, "Benedito Lacerda", "Benedicto Lacerda", 1903, 1958, p5);
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
		paisRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
		funcaoRepository.saveAll(Arrays.asList(f1, f2));
		artistaRepository.saveAll(Arrays.asList(a1, a2, a3, a4, a5, a6, a7, a8, a9));
		
		Genero g1 = new Genero(null, "Clássico", p6);
		Genero g2 = new Genero(null, "Samba", p5);
		Musica m1 = new Musica(null, "Concerto para Piano e Orquestra nº 5", g1);
		Musica m2 = new Musica(null, "O Lago dos Cisnes", g1); 
		Musica m3 = new Musica(null, "Quadros de Uma Exposição", g1);
		Musica m4 = new Musica(null, "Don Giovanni", g1);
		Musica m5 = new Musica(null, "Barcarole", g1);
		Musica m6 = new Musica(null, "Partita nº 4", g1);
		Musica m7 = new Musica(null, "Página de Dôr", g2);
		Musica m8 = new Musica(null, "Urubu", g2);
		generoRepository.saveAll(Arrays.asList(g1, g2));
		musicaRepository.saveAll(Arrays.asList(m1, m2, m3, m4, m5, m6, m7, m8));
		
		MusicaArtistaFuncao maf1 = new MusicaArtistaFuncao(m1, a1, f1); 
		MusicaArtistaFuncao maf2 = new MusicaArtistaFuncao(m2, a2, f1);
		MusicaArtistaFuncao maf3 = new MusicaArtistaFuncao(m3, a4, f1);
		MusicaArtistaFuncao maf4 = new MusicaArtistaFuncao(m4, a3, f1);
		MusicaArtistaFuncao maf5 = new MusicaArtistaFuncao(m5, a5, f1);
		MusicaArtistaFuncao maf6 = new MusicaArtistaFuncao(m6, a6, f1);
		MusicaArtistaFuncao maf7 = new MusicaArtistaFuncao(m7, a7, f1);
		MusicaArtistaFuncao maf8 = new MusicaArtistaFuncao(m7, a8, f1);
		MusicaArtistaFuncao maf9 = new MusicaArtistaFuncao(m8, a7, f1);
		m1.getMusicaItens().addAll(Arrays.asList(maf1));
		m2.getMusicaItens().addAll(Arrays.asList(maf2));
		m3.getMusicaItens().addAll(Arrays.asList(maf3));
		m4.getMusicaItens().addAll(Arrays.asList(maf4));
		m5.getMusicaItens().addAll(Arrays.asList(maf5));
		m6.getMusicaItens().addAll(Arrays.asList(maf6));
		m7.getMusicaItens().addAll(Arrays.asList(maf7, maf9));
		m8.getMusicaItens().addAll(Arrays.asList(maf8));
		
		musicaArtistaFuncaoRepository.saveAll(Arrays.asList(maf1, maf2, maf3, maf4, maf5, maf6, maf7, maf8, maf9));

	}
}
