package com.castelli.acervo.domain.enums;

public enum Conservacao {

	SELADO(1, "Selado"),
	PERFEITO(2,"Perfeito"),
	QUASEPERFEITO(3, "Quase perfeito"),
	EXCELENTE(4, "Excelente"),
	MUITOBOM(5, "Muito bom"),
	BOM(6, "Bom"),
	REGULAR(7, "Regular"),
	RUIM(8, "Ruim"),
	SEMCAPA(9, "Sem capa");
	
	private int cod;
	private String descricao;

	private Conservacao(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Conservacao toEnum(Integer id) {
		if (id == null) {
			return null;
		}
		for (Conservacao x : Conservacao.values()) {
			if (id.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido " + id);
	}
}
