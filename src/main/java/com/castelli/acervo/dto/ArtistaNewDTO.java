package com.castelli.acervo.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import com.castelli.acervo.services.validation.ArtistaInsert;

@ArtistaInsert
public class ArtistaNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=3, max=80, message = "Tamanho deve estar entre 3 e 80 caracteres")
	private String alias;	
	
	private String nome;
	private Integer nascimento;
	private Integer obito;
	private Integer funcaoId;
	private Integer paisId;
		
	public ArtistaNewDTO() {}

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

	public Integer getFuncaoId() {
		return funcaoId;
	}

	public void setFuncaoId(Integer funcaoId) {
		this.funcaoId = funcaoId;
	}
	
	public Integer getPaisId() {
		return paisId;
	}

	public void setPaisId(Integer paisId) {
		this.paisId = paisId;
	}
}
