package com.castelli.acervo.domain;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class FaixaCredito implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private FaixaCreditoPK id = new FaixaCreditoPK();
	
	public FaixaCredito() {}
	
	public FaixaCredito(Faixa faixa, Artista artista, Funcao funcao) {
		id.setFaixa(faixa);
		id.setArtista(artista);
		id.setFuncao(funcao);
	}
	
	public Faixa getFaixa() {
		return id.getFaixa();
	}
	
	@JsonIgnore
	public Artista getArtista() {
		return id.getArtista();
	}
	
	public Funcao getFuncao() {
		return id.getFuncao();
	}
	
	public FaixaCreditoPK getId() {
		return id;
	}

	public void setId(FaixaCreditoPK id) {
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
		FaixaCredito other = (FaixaCredito) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
