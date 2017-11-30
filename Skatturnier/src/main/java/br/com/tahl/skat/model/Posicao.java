package br.com.tahl.skat.model;

public enum Posicao {
	A, B, C, D;

	public static Posicao[] posicoes4Jogadores() {
		return new Posicao[] {Posicao.A, Posicao.B, Posicao.C, Posicao.D};
	}
	
	public static Posicao[] posicoes3Jogadores() {
		return new Posicao[] {Posicao.A, Posicao.B, Posicao.C};
	}
}

