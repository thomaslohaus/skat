package br.com.tahl.skat.reports;

import java.util.ArrayList;
import java.util.List;

import br.com.tahl.skat.model.Jogador;
import br.com.tahl.skat.model.Pontuacao;
import br.com.tahl.skat.model.Rodada;
import br.com.tahl.skat.utils.Pontos;
import br.com.tahl.skat.utils.RefJogador;

public class ResultadoRodadaJogador implements RefJogador, Pontos {

	private Rodada rodada;
	private Jogador jogador;
	private List<Pontuacao> series;
	private int pontosTotais;
	private int classificacao;

	public ResultadoRodadaJogador (Rodada rodada, Jogador jogador) {
		this.rodada = rodada;
		this.jogador = jogador;
	}
	
	public Rodada getRodada() {
		return rodada;
	}
	
	public Jogador getJogador() {
		return jogador;
	}

	public List<Pontuacao> getSeries() {
		return series;
	}

	public void adicionarSerie(Pontuacao pontuacao) {
		if (series == null)
			series = new ArrayList<Pontuacao>();

		if (pontuacao != null) {
			series.add(pontuacao);
		}
	}

	public int getPontosTotais() {
		return pontosTotais;
	}

	public void setPontosTotais(int pontosTotais) {
		this.pontosTotais = pontosTotais;
	}

	public int getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}

}
