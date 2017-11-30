package br.com.tahl.skat.utils;

public class NumeroDeJogadoresException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public NumeroDeJogadoresException(int jogadores) {
		super("Não é possível gerar uma mesa com " + jogadores + " jogador(es)!");
	}
}
