package com.castelli.acervo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.castelli.acervo.domain.enums.Conservacao;
import com.castelli.acervo.domain.enums.Fisico;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Disco implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String título;
	private String compositor;
	private String assunto;
	private String matriz1;
	private String matriz2;
	private String comercial;
	private Integer lancado;
	private String nota;
	private Integer disco;
	private Integer capa;
	private Integer fisico;
	
	@ManyToOne
	@JoinColumn(name = "selo_id")
	private Selo selo;
	
	@ManyToOne
	@JoinColumn(name = "colecao_id")
	private Colecao colecao;
	
	@ManyToOne
	@JoinColumn(name = "pais_id")
	private Pais pais;
	
	@JsonIgnore
	@OneToMany(mappedBy = "disco")
	private List<Faixa> faixas = new ArrayList<>();

	public Disco() {}

	public Disco(Integer id, String título, String compositor, String assunto, String matriz1, String matriz2,
			String comercial, Integer lancado, String nota, Conservacao disco, Conservacao capa, Fisico fisico, Selo selo,
			Colecao colecao, Pais pais) {
		this.id = id;
		this.título = título;
		this.compositor = compositor;
		this.assunto = assunto;
		this.matriz1 = matriz1;
		this.matriz2 = matriz2;
		this.comercial = comercial;
		this.lancado = lancado;
		this.nota = nota;
		this.disco = disco.getCod();
		this.capa = capa.getCod();
		this.fisico = fisico.getCod();
		this.selo = selo;
		this.colecao = colecao;
		this.pais = pais;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTítulo() {
		return título;
	}

	public void setTítulo(String título) {
		this.título = título;
	}

	public String getCompositor() {
		return compositor;
	}

	public void setCompositor(String compositor) {
		this.compositor = compositor;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getMatriz1() {
		return matriz1;
	}

	public void setMatriz1(String matriz1) {
		this.matriz1 = matriz1;
	}

	public String getMatriz2() {
		return matriz2;
	}

	public void setMatriz2(String matriz2) {
		this.matriz2 = matriz2;
	}

	public String getComercial() {
		return comercial;
	}

	public void setComercial(String comercial) {
		this.comercial = comercial;
	}

	public Integer getLancado() {
		return lancado;
	}

	public void setLancado(Integer lancado) {
		this.lancado = lancado;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public Conservacao getDisco() {
		return Conservacao.toEnum(disco);
	}

	public void setDisco(Conservacao disco) {
		this.disco = disco.getCod();
	}

	public Conservacao getCapa() {
		return Conservacao.toEnum(capa);
	}

	public void setCapa(Conservacao capa) {
		this.capa = capa.getCod();
	}

	public Fisico getFisico() {
		return Fisico.toEnum(fisico);
	}

	public void setFisico(Fisico fisico) {
		this.fisico = fisico.getCod();
	}

	public Selo getSelo() {
		return selo;
	}

	public void setSelo(Selo selo) {
		this.selo = selo;
	}

	public Colecao getColecao() {
		return colecao;
	}

	public void setColecao(Colecao colecao) {
		this.colecao = colecao;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<Faixa> getFaixas() {
		return faixas;
	}

	public void setFaixas(List<Faixa> faixas) {
		this.faixas = faixas;
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
		Disco other = (Disco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
