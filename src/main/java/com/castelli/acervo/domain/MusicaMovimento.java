package com.castelli.acervo.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MusicaMovimento extends Musica {
	private static final long serialVersionUID = 1L;

	private String opus;
	
	@ManyToOne
	@JoinColumn(name = "estilo_id")
	private Estilo estilo;
	
	//@JsonIgnore
	@OneToMany(mappedBy="musicaMovimento")
	private List<Movimento> movimentos = new ArrayList<>();
	
	public MusicaMovimento() {}

	public MusicaMovimento(Integer id, String nome, Genero genero, String opus, Estilo estilo) {
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

	@JsonIgnore
	public List<Movimento> getMovimentos() {
		return movimentos;
	}

	public void setMovimentos(List<Movimento> movimentos) {
		this.movimentos = movimentos;
	}
}

