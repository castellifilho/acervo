package com.castelli.acervo.domain.enums;

public enum Fisico {

	D78G10M(1, "Disco: 78rpm, goma-laca, 25cm, mono"),
	D78G12M(2, "Disco: 78rpm, goma-laca, 30cm, mono"),
	D33V07S(3, "Disco: 33rpm, vinil, 17cm, estéreo"),
	D33V10S(4, "Disco: 33rpm, vinil, 25cm, estéreo"),
	D33V12S(5, "Disco: 33rpm, vinil, 30cm, estéreo"),
	D33V12M(6, "Disco: 33rpm, vinil, 30cm, mono"),
	D33V10M(7, "Disco: 33rpm, vinil, 25cm, mono");
	
	private int cod;
	private String descricao;

	private Fisico(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Fisico toEnum(Integer id) {
		if (id == null) {
			return null;
		}
		for (Fisico x : Fisico.values()) {
			if (id.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido " + id);
	}
}
