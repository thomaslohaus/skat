package br.com.tahl.skat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.tahl.skat.utils.Pontos;
import br.com.tahl.skat.utils.RefJogador;

@Entity
public class Pontuacao implements RefJogador, Pontos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Rodada rodada;
	private int serie;
	@ManyToOne
	private Jogador jogador;
	private int pontosJogo;
	private int pontosTotais;
	private int jogosGanhos;
	private int jogosPerdidos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Rodada getRodada() {
		return rodada;
	}

	public void setRodada(Rodada rodada) {
		this.rodada = rodada;
	}

	public int getSerie() {
		return serie;
	}

	public void setSerie(int serie) {
		this.serie = serie;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public int getPontosJogo() {
		return pontosJogo;
	}

	public void setPontosJogo(int pontosJogo) {
		this.pontosJogo = pontosJogo;
	}

	public int getPontosTotais() {
		return pontosTotais;
	}

	public void setPontosTotais(int pontosTotais) {
		this.pontosTotais = pontosTotais;
	}

	public int getJogosGanhos() {
		return jogosGanhos;
	}

	public void setJogosGanhos(int jogosGanhos) {
		this.jogosGanhos = jogosGanhos;
	}

	public int getJogosPerdidos() {
		return jogosPerdidos;
	}

	public void setJogosPerdidos(int jogosPerdidos) {
		this.jogosPerdidos = jogosPerdidos;
	}
	
	@Override
	public String toString() {
		return "Rodada: " + rodada.getNumero() + " - Serie: " + serie + " | Jogador: " + jogador.getNome() + " | Jogos Ganhos: " + jogosGanhos + " | Jogos Perdidos: " + jogosPerdidos + " | Total: " + pontosTotais; 
	}
}
