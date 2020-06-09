package com.castelli.acervo.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import com.castelli.acervo.domain.Artista;
import com.castelli.acervo.services.validation.ArtistaUpdate;

@ArtistaUpdate
public class ArtistaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=3, max=80, message = "Tamanho deve estar entre 3 e 80 caracteres")
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
