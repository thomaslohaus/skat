package br.com.tahl.skat.security;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.tahl.skat.model.Jogador;

@SuppressWarnings("serial")
@Named
@SessionScoped
public class JogadorLogado implements Serializable {
	
	private Jogador jogador;
	
	public Jogador getJogador() {
		return jogador;
	}
	
	public void fazLogin(Jogador jogador) {
		this.jogador = jogador;
	}
	
	public void desloga() {
		this.jogador = null;
	}
	
	public boolean isLogado() {
		return this.jogador != null;
	}
}
