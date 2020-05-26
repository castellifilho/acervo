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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Funcao implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@ManyToMany(mappedBy = "funcoes")
	private List<Artista> artistas = new ArrayList<>();
	
	@JsonIgnore 
	@OneToMany(mappedBy = "id.funcao")
	private Set<MusicaArtistaFuncao> musicaItens = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.funcao")
	private Set<FaixaCredito> faixaItens = new HashSet<>();
	
	public Funcao() {}

	public Funcao(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@JsonIgnore  //20 para o endpoint faixas apenas
	public List<Artista> getArtistas() {
		return artistas;
	}

	public void setArtistas(List<Artista> artistas) {
		this.artistas = artistas;
	}	
	
	public Set<MusicaArtistaFuncao> getMusicaItens() {
		return musicaItens;
	}

	@OneToMany(mappedBy = "id.funcao")
	public void setMusicaItens(Set<MusicaArtistaFuncao> musicaItens) {
		this.musicaItens = musicaItens;
	}
	
	public Set<FaixaCredito> getFaixaItens() {
		return faixaItens;
	}

	@OneToMany(mappedBy = "id.funcao")
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
		Funcao other = (Funcao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}