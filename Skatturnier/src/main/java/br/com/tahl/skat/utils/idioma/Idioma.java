package br.com.tahl.skat.utils.idioma;

public enum Idioma {
	ALEMAO ("Deutsch", "de", "bandeira-alemanha.png"),
	INGLES ("English", "en", "bandeira-reino-unido.png"),
	PORTUGUES ("Português", "pt", "bandeira-brasil.png");
	
	private String nome;
	private String sigla;
	private String iconeBandeira;

	Idioma(String nome, String sigla, String iconeBandeira) {
		this.nome = nome;
		this.sigla = sigla;
		this.iconeBandeira = iconeBandeira;
	}

	public String getNome() {
		return nome;
	}

	public String getSigla() {
		return sigla;
	}

	public String getIconeBandeira() {
		return iconeBandeira;
	}
	
	public static Idioma getIdiomaPadrao() {
		return Idioma.PORTUGUES;
	}
}
