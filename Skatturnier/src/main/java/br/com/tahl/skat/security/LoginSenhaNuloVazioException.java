package br.com.tahl.skat.security;

public class LoginSenhaNuloVazioException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public LoginSenhaNuloVazioException() {
		super("A senha não pode ser nula ou vazia!");
	}
}
