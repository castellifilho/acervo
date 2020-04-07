package com.castelli.acervo.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MusicaEstilo extends Musica {
	private static final long serialVersionUID = 1L;

	private String opus;
	
	@ManyToOne
	@JoinColumn(name = "estilo_id")
	private Estilo estilo;
	
	public MusicaEstilo() {}

	public MusicaEstilo(Integer id, String nome, Genero genero, String opus, Estilo estilo) {
		super(id, nome, genero);
		this.opus = opus;
		this.estilo = estilo;
	}

	public String getOpus() {
		return opus;
	}

	public void setOpus(String opus) {
		this.opus = opus;
	}

	public Estilo getEstilo() {
		return estilo;
	}

	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}
}
