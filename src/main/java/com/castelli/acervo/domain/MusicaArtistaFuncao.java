package com.castelli.acervo.domain;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MusicaArtistaFuncao implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private MusicaArtistaFuncaoPK id = new MusicaArtistaFuncaoPK();
	
	public MusicaArtistaFuncao() {}
	
	public MusicaArtistaFuncao(Musica musica, Artista artista, Funcao funcao) {
		id.setMusica(musica);
		id.setArtista(artista);
		id.setFuncao(funcao);
	}

	@JsonIgnore
    public Musica getMusica() {
		return id.getMusica();
	}
	
	//@JsonIgnore
	public Artista getArtista() {
		return id.getArtista();
	}
	
	@JsonIgnore  // Pega todos os artistas com a mesma função
	public Funcao getFuncao() {
		return id.getFuncao();
	}
	
	@JsonIgnore
	public MusicaArtistaFuncaoPK getId() {
		return id;
	}

	public void setId(MusicaArtistaFuncaoPK id) {
		this.id = id;
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
		MusicaArtistaFuncao other = (MusicaArtistaFuncao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
