package com.castelli.acervo.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Movimento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String movimento;
	private String andamento;
	
	@ManyToOne
	@JoinColumn(name="musica_id")
	private MusicaMovimento musicaMovimento;
	
	public Movimento() {}

	public Movimento(Integer id, String movimento, String andamento, MusicaMovimento musicaMovimento) {
		this.id = id;
		this.movimento = movimento;
		this.andamento = andamento;
		this.musicaMovimento = musicaMovimento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMovimento() {
		return movimento;
	}

	public void setMovimento(String movimento) {
		this.movimento = movimento;
	}

	public String getAndamento() {
		return andamento;
	}

	public void setAndamento(String andamento) {
		this.andamento = andamento;
	}

	public Musica getMusicaMovimento() {
		return musicaMovimento;
	}

	public void setMusicaMovimento(MusicaMovimento musicaMovimento) {
		this.musicaMovimento = musicaMovimento;
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
		Movimento other = (Movimento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
