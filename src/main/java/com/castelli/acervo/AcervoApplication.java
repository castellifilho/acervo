package com.castelli.acervo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.castelli.acervo.domain.Artista;
import com.castelli.acervo.domain.Colecao;
import com.castelli.acervo.domain.Disco;
import com.castelli.acervo.domain.Estilo;
import com.castelli.acervo.domain.Funcao;
import com.castelli.acervo.domain.Genero;
import com.castelli.acervo.domain.Gravadora;
import com.castelli.acervo.domain.Grupo;
import com.castelli.acervo.domain.GrupoMusical;
import com.castelli.acervo.domain.Movimento;
import com.castelli.acervo.domain.Musica;
import com.castelli.acervo.domain.MusicaArtistaFuncao;
import com.castelli.acervo.domain.MusicaEstilo;
import com.castelli.acervo.domain.MusicaMovimento;
import com.castelli.acervo.domain.Pais;
import com.castelli.acervo.domain.Selo;
import com.castelli.acervo.domain.Serie;
import com.castelli.acervo.repositories.ArtistaRepository;
import com.castelli.acervo.repositories.ColecaoRepository;
import com.castelli.acervo.repositories.EstiloRepository;
import com.castelli.acervo.repositories.FuncaoRepository;
import com.castelli.acervo.repositories.GeneroRepository;
import com.castelli.acervo.repositories.GravadoraRepository;
import com.castelli.acervo.repositories.GrupoMusicalRepository;
import com.castelli.acervo.repositories.GrupoRepository;
import com.castelli.acervo.repositories.MovimentoRepository;
import com.castelli.acervo.repositories.MusicaArtistaFuncaoRepository;
import com.castelli.acervo.repositories.MusicaRepository;
import com.castelli.acervo.repositories.PaisRepository;
import com.castelli.acervo.repositories.SeloRepository;
import com.castelli.acervo.repositories.SerieRepository;

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
	private EstiloRepository estiloRepository;
	@Autowired
	private MusicaRepository musicaRepository;
	@Autowired
	private MusicaArtistaFuncaoRepository musicaArtistaFuncaoRepository;
	@Autowired
	private MovimentoRepository movimentoRepository;
	@Autowired
	private GravadoraRepository gravadoraRepository;
	@Autowired
	private SeloRepository seloRepository;
	@Autowired
	private GrupoRepository grupoRepository;
	@Autowired
	private GrupoMusicalRepository grupoMusicalRepository;
	@Autowired
	private ColecaoRepository colecaoRepository;
	@Autowired
	private SerieRepository serieRepository;
	
	
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
		Pais p6 = new Pais(null, "indefinidol"); 
		Pais p7 = new Pais(null, "Eslovênia");
		Pais p8 = new Pais(null, "República Checa");
		Pais p9 = new Pais(null, "Reino Unido");
		Pais p10 = new Pais(null, "India");
		Pais p11 = new Pais(null, "Bélgica");
		Pais p12 = new Pais(null, "Itália");
		Pais p13 = new Pais(null, "Hungria");
		Pais p14 = new Pais(null, "Escócia");
		Funcao f1 = new Funcao(null, "Compositor");
		Funcao f2 = new Funcao(null, "Cantor");
		Funcao f3 = new Funcao(null, "Maestro");
		Funcao f4 = new Funcao(null, "Barítono");
		Funcao f5 = new Funcao(null, "Piano");
		Funcao f6 = new Funcao(null, "Soprano");
		Funcao f7 = new Funcao(null, "Baixo operístico");
		Funcao f8 = new Funcao(null, "Tenor");
		Funcao f9 = new Funcao(null, "Violino");
		Funcao f10 = new Funcao(null, "Cantora");
		Funcao f11 = new Funcao(null, "Lider de Orquestra");
		Artista a1 = new Artista(null, "Beethoven", "Ludwig van Beethoven", 1770, 1827, p1);
		Artista a2 = new Artista(null, "Tchaikovski", "Piotr Ilitch Tchaikovski", 1840, 1893, p2);
		Artista a3 = new Artista(null, "Mozart", "Wolfgang Amadeus Mozart", 1756, 1791, p3); 
		Artista a4 = new Artista(null, "Mussorgsky", "Modest Petrovich Mussorgsky", 1839, 1881, p2);
		Artista a5 = new Artista(null, "Chopin", "Frédéric François Chopin", 1810, 1849, p4);
		Artista a6 = new Artista(null, "Bach", "Johann Sebastian Bach", 1685, 1750, p1);
		Artista a7 = new Artista(null, "Pixinguinha", "Alfredo da Rocha Vianna Filho", 1897, 1973, p5);
		Artista a8 = new Artista(null, "Cândido das Neves", "Cândido das Neves", 1899, 1934, p5);
		Artista a9 = new Artista(null, "Benedito Lacerda", "Benedicto Lacerda", 1903, 1958, p5);
		Artista a10 = new Artista(null, "Zubin Mehta", "Zubin Mehta", 1936, null, p10);
		Artista a11 = new Artista(null, "Alfred Brendel", "Alfred Brendel", 1931, null, p8);
		Artista a12 = new Artista(null, "Edouard van Remoortel", "Edouard van Remoortel", 1926, 1977, p11);
		Artista a13 = new Artista(null, "Hans Swarowsky", "Hans Swarowsky", 1899, 1975, p13);
		Artista a14 = new Artista(null, "Gianni Maffeo", "Gianni Maffeo", 1939, null, p12);
		Artista a15 = new Artista(null, "Gabriella Ravazzi", "Gabriella Ravazzi", null, null, p12);
		Artista a16 = new Artista(null, "Orazio Mori", "Orazio Mori", null, null, p6);
		Artista a17 = new Artista(null, "Silvano Pagliuca", "Silvano Pagliuca", null, null, p6);
		Artista a18 = new Artista(null, "Gino Tadei", "Gino Tadei", 1933, 2017, p12);
		Artista a19 = new Artista(null, "György Cziffra", "György Cziffra", 1921, 1994, p13);
		Artista a20 = new Artista(null, "João Carlos Martins", "João Carlos Martins", 1940, null, p5);
		Artista a21 = new Artista(null, "Franzjosef Maier", "Franzjosef Maier", 1925, 2014, p1);
		Artista a22 = new Artista(null, "Adelino Moreira", " Adelino Moreira de Castro", 1918, 2002, p5);
		Artista a23 = new Artista(null, "Ary Barroso", " Ary Evangelista Barroso", 1903, 1964, p5);
		Artista a24 = new Artista(null, "Dalva de Oliveira", "Dalva de Oliveira", 1917, 1972, p5);
		Artista a25 = new Artista(null, "Humberto Teixeira", "Humberto Cavalcanti Teixeira", 1915, 1979, p5);
		Artista a26 = new Artista(null, "Ataulfo Alves", "Ataulfo Alves de Sousa", 1909, 1969, p5);
		Artista a27 = new Artista(null, "Roberto Inglez", "Roberto Inglis", 1913, 1978, p14);
		Artista a28 = new Artista(null, "Orlando Silva", "Orlando Garcia da Silva", 1915, 1978, p5);
		f1.getArtistas().addAll(Arrays.asList(a1, a2, a3, a4, a5, a6, a7, a8, a9, a22, a23, a25, a26));
		f2.getArtistas().addAll(Arrays.asList(a7, a9, a27));
		f3.getArtistas().addAll(Arrays.asList(a10, a12, a13));
		f4.getArtistas().addAll(Arrays.asList(a14, a16));
		f5.getArtistas().addAll(Arrays.asList(a11, a19, a20));
		f6.getArtistas().addAll(Arrays.asList(a15));
		f7.getArtistas().addAll(Arrays.asList(a17));
		f8.getArtistas().addAll(Arrays.asList(a18));
		f9.getArtistas().addAll(Arrays.asList(a21));
		f10.getArtistas().addAll(Arrays.asList(a24));
		f11.getArtistas().addAll(Arrays.asList(a27));
		a1.getFuncoes().addAll(Arrays.asList(f1));
		a2.getFuncoes().addAll(Arrays.asList(f1));
		a3.getFuncoes().addAll(Arrays.asList(f1));
		a4.getFuncoes().addAll(Arrays.asList(f1));
		a5.getFuncoes().addAll(Arrays.asList(f1));
		a6.getFuncoes().addAll(Arrays.asList(f1));
		a7.getFuncoes().addAll(Arrays.asList(f1, f2));
		a8.getFuncoes().addAll(Arrays.asList(f1));
		a9.getFuncoes().addAll(Arrays.asList(f1, f2));
		a10.getFuncoes().addAll(Arrays.asList(f3));
		a11.getFuncoes().addAll(Arrays.asList(f5));
		a12.getFuncoes().addAll(Arrays.asList(f3));
		a13.getFuncoes().addAll(Arrays.asList(f3));
		a14.getFuncoes().addAll(Arrays.asList(f4));
		a15.getFuncoes().addAll(Arrays.asList(f6));
		a16.getFuncoes().addAll(Arrays.asList(f4));
		a17.getFuncoes().addAll(Arrays.asList(f7));
		a18.getFuncoes().addAll(Arrays.asList(f8));
		a19.getFuncoes().addAll(Arrays.asList(f5));
		a20.getFuncoes().addAll(Arrays.asList(f5));
		a21.getFuncoes().addAll(Arrays.asList(f9));
		a22.getFuncoes().addAll(Arrays.asList(f1));
		a23.getFuncoes().addAll(Arrays.asList(f1));
		a24.getFuncoes().addAll(Arrays.asList(f10));
		a25.getFuncoes().addAll(Arrays.asList(f1));
		a26.getFuncoes().addAll(Arrays.asList(f1));
		a27.getFuncoes().addAll(Arrays.asList(f11));
		a28.getFuncoes().addAll(Arrays.asList(f2));
		paisRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14));
		funcaoRepository.saveAll(Arrays.asList(f1, f2, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11));
		artistaRepository.saveAll(Arrays.asList(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22, a23, a24, a25, a26, a27, a28));

		Genero g1 = new Genero(null, "Clássico", "Romantico", p6);
		Genero g2 = new Genero(null, "Clássico", "", p6);
		Genero g3 = new Genero(null, "Samba", "Samba-chôro", p5);
		Genero g4 = new Genero(null, "Seresta", "", p5);
		Genero g5 = new Genero(null, "Baião", "", p5);
		Genero g6 = new Genero(null, "Latina", "Valsa", p5);
		Genero g7 = new Genero(null, "Clássico", "Barroco", p6);
		Genero g8 = new Genero(null, "Samba", "Samba-canção", p5);
		Estilo e1 = new Estilo(null, "Concerto");
		Estilo e2 = new Estilo(null, "Ballet ");
		Estilo e3 = new Estilo(null, "Suite");
		Estilo e4 = new Estilo(null, "Ópera");
		Estilo e5 = new Estilo(null, "Barcarola");
		Estilo e6 = new Estilo(null, "Partita");
		Musica m1 = new MusicaMovimento(null, "Concerto para Piano e Orquestra nº 5", g1, "Opus 73 (Imperador)", e1);
		Musica m2 = new MusicaMovimento(null, "O Lago dos Cisnes", g2, "", e2 ); 
		Musica m3 = new MusicaMovimento(null, "Quadros de Uma Exposição", g1, "", e3 );
		Musica m4 = new MusicaMovimento(null, "Don Giovanni", g2, "", e4);
		Musica m5 = new MusicaEstilo(null, "Barcarolle", g1,  "Opus 60", e5);
		Musica m6 = new MusicaMovimento (null, "Partita nº 4", g7, "", e6);
		Musica m7 = new Musica(null, "Página de Dôr", g6);
		Musica m8 = new Musica(null, "Urubu", g3);
		Musica m9 = new Musica(null, "A Volta do Boêmio", g4);
		Musica m10 = new Musica(null, "Risque", g4);
		Musica m11 = new Musica(null, "Kalú", g5);
		Musica m12 = new Musica(null, "Fim de Comédia", g8);
		generoRepository.saveAll(Arrays.asList(g1, g2, g3, g4, g5, g6, g7, g8));
		estiloRepository.saveAll(Arrays.asList(e1, e2, e3, e4, e5, e6));
		musicaRepository.saveAll(Arrays.asList(m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12));
				
		Movimento mov1 = new Movimento(null, "1º", "Allegro", (MusicaMovimento) m1);
		Movimento mov2 = new Movimento(null, "2º", "Adagio um poco mosso", (MusicaMovimento) m1);
		Movimento mov3 = new Movimento(null, "3º", "Rondó (Allegro)", (MusicaMovimento) m1);
		Movimento mov4 = new Movimento(null, "1", "Cena", (MusicaMovimento) m2);
		Movimento mov5 = new Movimento(null, "2", "Valsa", (MusicaMovimento) m2);
		Movimento mov6 = new Movimento(null, "3", "Dança dos Cisnes", (MusicaMovimento) m2);
		Movimento mov7 = new Movimento(null, "4", "Cena", (MusicaMovimento) m2);
		Movimento mov8 = new Movimento(null, "5", "Dança Húngara: Czards", (MusicaMovimento) m2);
		Movimento mov9 = new Movimento(null, "1", "Promedame", (MusicaMovimento) m3);
		Movimento mov10 = new Movimento(null, "2", "Gnomus", (MusicaMovimento) m3);
		Movimento mov11 = new Movimento(null, "15", "La Grande Porte de Kiev", (MusicaMovimento) m3);
		Movimento mov12 = new Movimento(null, "1", "Abertura", (MusicaMovimento) m4);
		Movimento mov13 = new Movimento(null, "Ato I (cena V)", "Madamina, il catalogo è questo", (MusicaMovimento) m4);
		Movimento mov14 = new Movimento(null, "Ato II (cena III)", "Deb, vieni ala finestra", (MusicaMovimento) m4);
		Movimento mov15 = new Movimento(null, "1", "Overture", (MusicaMovimento) m6);
		Movimento mov16 = new Movimento(null, "2", "Allemande", (MusicaMovimento) m6);
		Movimento mov17 = new Movimento(null, "7", "Gigue", (MusicaMovimento) m6);
		MusicaArtistaFuncao maf1 = new MusicaArtistaFuncao(m1, a1, f1); 
		MusicaArtistaFuncao maf2 = new MusicaArtistaFuncao(m2, a2, f1);
		MusicaArtistaFuncao maf3 = new MusicaArtistaFuncao(m3, a4, f1);
		MusicaArtistaFuncao maf4 = new MusicaArtistaFuncao(m4, a3, f1);
		MusicaArtistaFuncao maf5 = new MusicaArtistaFuncao(m5, a5, f1);
		MusicaArtistaFuncao maf6 = new MusicaArtistaFuncao(m6, a6, f1);
		MusicaArtistaFuncao maf7 = new MusicaArtistaFuncao(m7, a7, f1);
		MusicaArtistaFuncao maf8 = new MusicaArtistaFuncao(m7, a8, f1);
		MusicaArtistaFuncao maf9 = new MusicaArtistaFuncao(m8, a7, f1);
		MusicaArtistaFuncao maf10 = new MusicaArtistaFuncao(m9, a22, f1);
		MusicaArtistaFuncao maf11 = new MusicaArtistaFuncao(m10, a23, f1);
		MusicaArtistaFuncao maf12 = new MusicaArtistaFuncao(m11, a25, f1);
		MusicaArtistaFuncao maf13 = new MusicaArtistaFuncao(m12, a26, f1);
		m1.getMusicaItens().addAll(Arrays.asList(maf1));
		m2.getMusicaItens().addAll(Arrays.asList(maf2));
		m3.getMusicaItens().addAll(Arrays.asList(maf3));
		m4.getMusicaItens().addAll(Arrays.asList(maf4));
		m5.getMusicaItens().addAll(Arrays.asList(maf5));
		m6.getMusicaItens().addAll(Arrays.asList(maf6));
		m7.getMusicaItens().addAll(Arrays.asList(maf7, maf9));
		m8.getMusicaItens().addAll(Arrays.asList(maf8));
		m9.getMusicaItens().addAll(Arrays.asList(maf10));
		m10.getMusicaItens().addAll(Arrays.asList(maf11));
		m11.getMusicaItens().addAll(Arrays.asList(maf12));
		m12.getMusicaItens().addAll(Arrays.asList(maf13));
		movimentoRepository.saveAll(Arrays.asList(mov1, mov2, mov3, mov4, mov5, mov6, mov7, mov8, mov9, mov10, mov11, mov12, mov13, mov14, mov15, mov16, mov17));
		musicaArtistaFuncaoRepository.saveAll(Arrays.asList(maf1, maf2, maf3, maf4, maf5, maf6, 
		         maf7, maf8, maf9, maf10, maf11, maf12, maf13));
		
		Gravadora gv1 = new Gravadora(null, "Abril S/A Cultural e Industrial", " Foi transformada em 1982 na Editora Nova Cultural ", 1950, 1982, p5);
		Gravadora gv2 = new Gravadora(null, "EMI Records Lda", "Vendida para a PLG Holdco Ltd. (Parlophone Label Group)", 1973, 2012, p9);
		Gravadora gv3 = new Gravadora(null, "Ariola Discos Fonográficos e Fitas Magnéticas Ltda", 
				"Comprada em 1983 pela Polygram, passando a se chamar Barclay até 1987", 1980, 1983, p5);
		Gravadora gv4 = new Gravadora(null, "Companhia Industrial de Discos - CID", "Em atividade", 1958, null, p5);
		Gravadora gv5 = new Gravadora(null, "Indústrias Elétricas e Musicais Fábrica Odeon S.A.", 
				"Em 1974, a empresa foi renomeada como EMI-Odeon Fonográfica, Industrial e Eletrônica SA.", 1931, 1974, p5);
		Selo s1 = new Selo(null, "ABRIL CULTURAL");
		Selo s2 = new Selo(null, "EMI Angel ");
		Selo s3 = new Selo(null, "Ariola ");
		Selo s4 = new Selo(null, "CID ");
		Selo s5 = new Selo(null, "ODEON");
		Grupo gp1 = new Grupo(null, "Orquestra Sinfônica");
		Grupo gp2 = new Grupo(null, "Orquestra de Cãmara");
		Grupo gp3 = new Grupo(null, "Coral");
		GrupoMusical gm1 = new GrupoMusical(null, "Orquestra Pró-Música de Viena", "", gp1, p3);
		GrupoMusical gm2 = new GrupoMusical(null, "Orquestra Sinfônica de Viena", "", gp1, p3);
		GrupoMusical gm3 = new GrupoMusical(null, "Orquestra Sinfônica de Ljubjana", "", gp1, p7);
		GrupoMusical gm4 = new GrupoMusical(null, "Orquestra de Câmara de Praga", "", gp2, p8);
		GrupoMusical gm5 = new GrupoMusical(null, "Coral da Filarmônica de Praga", "", gp3, p8);
		s1.getGravadoras().addAll(Arrays.asList(gv1));
		s2.getGravadoras().addAll(Arrays.asList(gv2));
		s3.getGravadoras().addAll(Arrays.asList(gv3));
		s4.getGravadoras().addAll(Arrays.asList(gv4));
		s5.getGravadoras().addAll(Arrays.asList(gv5));
		gv1.getSelos().addAll(Arrays.asList(s1));
		gv2.getSelos().addAll(Arrays.asList(s2));
		gv3.getSelos().addAll(Arrays.asList(s3));
		gv4.getSelos().addAll(Arrays.asList(s4));
		gv5.getSelos().addAll(Arrays.asList(s5));
		gravadoraRepository.saveAll(Arrays.asList(gv1, gv2, gv3, gv4, gv5));
		seloRepository.saveAll(Arrays.asList(s1, s2, s3, s4, s5));
		grupoRepository.saveAll(Arrays.asList(gp1, gp2, gp3));
		grupoMusicalRepository.saveAll(Arrays.asList(gm1, gm2, gm3, gm4, gm5));
		
		Colecao c1 = new Colecao(null, "Mestres da Música", "Capa Gatefold com 12 páginas, mais 1 livreto", "coleção", gv1);
		Colecao c2 = new Colecao(null, "Mestres da Música (2ª edição)", "Capa Gatefold com 12 páginas, mais 1 livreto", "coleção", gv1);
		Colecao c3 = new Colecao(null, "As Grandes Óperas", "Capa Gatefold com 12 páginas, mais 1 livreto", "coleção", gv1);
		Colecao c4 = new Colecao(null, "Música Popular Brasileira", "Capa Gatefold com 12 páginas", "coleção", gv1);
		Colecao c5 = new Colecao(null, "Bons Tempos", "Serestas", "coleção", gv4);
		Serie se1 = new Serie(null, "nº 1", c2);
		Serie se2 = new Serie(null, "nº 2", c2);
		Serie se3 = new Serie(null, "nº 36", c1);
		Serie se4 = new Serie(null, "nº 5", c3);
		Serie se5 = new Serie(null, "nº 2", c4);
		Serie se6 = new Serie(null, "Vol. 3", c5);
		colecaoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));
		serieRepository.saveAll(Arrays.asList(se1, se2, se3, se4, se5, se6));
		
		//Faixa fx = new Faixa(null, faixa, musica, grupoMusical, disco);
		//FaixaCredito fc = new FaixaCredito(faixa, artista, funcao);
		//Disco d = new Disco(null, titulo, compositor, assunto, matriz1, matriz2, comercial, lancado, nota, disco, capa, fisico, selo, gravadora, serie, pais)
		
		
	}
}
