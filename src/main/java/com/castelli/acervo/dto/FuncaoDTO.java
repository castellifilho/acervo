package com.castelli.acervo.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import com.castelli.acervo.domain.Funcao;

public class FuncaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=5, max=80, message = "Tamanho deve estar entre 5 e 80 caracteres")
	private String nome;
	
	public FuncaoDTO() {}
	
	public FuncaoDTO(Funcao obj) {
		id=obj.getId();
		nome=obj.getNome();
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
}
