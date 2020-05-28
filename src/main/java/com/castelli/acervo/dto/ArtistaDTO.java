package com.castelli.acervo.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import com.castelli.acervo.domain.Artista;

public class ArtistaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=5, max=120, message = "Tamanho deve estar entre 5 e 120 caracteres")
	private String alias;
	
	private String nome;
	private Integer nascimento;
	private Integer obito;
	
	public ArtistaDTO() {}

	public ArtistaDTO(Artista obj) {
		id = obj.getId();
		alias = obj.getAlias();
		nome = obj.getNome();
		nascimento = obj.getNascimento();
		obito = obj.getObito();
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
}
