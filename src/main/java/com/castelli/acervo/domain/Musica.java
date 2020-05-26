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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Musica implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;	
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "genero_id")
	private Genero genero;
	
	@OneToMany(mappedBy="musica")
	private List<Movimento> movimentos = new ArrayList<>();
	
	//@JsonIgnore   //19 pega a musica, movimentos e artista, não pega a função.
	@OneToMany(mappedBy = "id.musica")
	private Set<MusicaArtistaFuncao> musicaItens = new HashSet<>();
	
	public Musica() {}

	public Musica(Integer id, String nome, Genero genero) {
		this.id = id;
		this.nome = nome;
		this.genero = genero;
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

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	@JsonIgnore  //20 não pega os movimentos no endpoint faixas
	public List<Movimento> getMovimentos() {
		return movimentos;
	}

	public void setMovimentos(List<Movimento> movimentos) {
		this.movimentos = movimentos;
	}

	//@JsonIgnore  
	public Set<MusicaArtistaFuncao> getMusicaItens() {
		return musicaItens;
	}

	@OneToMany(mappedBy = "id.musica")
	public void setMusicaItens(Set<MusicaArtistaFuncao> musicaItens) {
		this.musicaItens = musicaItens;
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
		Musica other = (Musica) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
