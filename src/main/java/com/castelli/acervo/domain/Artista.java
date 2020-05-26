package com.castelli.acervo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Artista implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String alias;
	private String nome;
	private Integer nascimento;
	private Integer obito;
	
	@ManyToOne
	@JoinColumn(name = "pais_id")
	private Pais pais;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "ARTISTA_FUNCAO",
	        joinColumns = @JoinColumn(name = "artista_id"),
	        inverseJoinColumns = @JoinColumn(name = "funcao_id"))
	private List<Funcao> funcoes = new ArrayList<>();
	
	@JsonIgnore  //Indiferente para endpoint musicas
	@OneToMany(mappedBy = "id.artista")
	private Set<MusicaArtistaFuncao> musicaItens = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.artista")
	private Set<FaixaCredito> faixaItens = new HashSet<>();
	
	public Artista() {}

	public Artista(Integer id, String alias, String nome, Integer nascimento, Integer obito, Pais pais) {
		this.id = id;
		this.alias = alias;
		this.nome = nome;
		this.nascimento = nascimento;
		this.obito = obito;
		this.pais = pais;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNascimento() {
		return nascimento;
	}

	public void setNascimento(Integer nascimento) {
		this.nascimento = nascimento;
	}

	public Integer getObito() {
		return obito;
	}

	public void setObito(Integer obito) {
		this.obito = obito;
	}
	
	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	//@JsonIgnore    // é indiferente para o endpoint funcoes
	public List<Funcao> getFuncoes() {
		return funcoes;
	}

	public void setFuncoes(List<Funcao> funcoes) {
		this.funcoes = funcoes;
	}
	
	@JsonIgnore 
	public Set<MusicaArtistaFuncao> getMusicaItens() {
		return musicaItens;
	}

	@OneToMany(mappedBy = "id.artista")
	public void setMusicaItens(Set<MusicaArtistaFuncao> musicaItens) {
		this.musicaItens = musicaItens;
	}
	
	@JsonIgnore
	public Set<FaixaCredito> getFaixaItens() {
		return faixaItens;
	}

	@OneToMany(mappedBy = "id.artista")
	public void setFaixaItens(Set<FaixaCredito> faixaItens) {
		this.faixaItens = faixaItens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artista other = (Artista) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
