package br.com.tahl.skat.reports;

import br.com.tahl.skat.model.Rodada;

public class EstatisticasSerie {

	private Rodada rodada;
	private int serie;
	private int numeroJogadores;
	private int jogosGanhos;
	private int jogosPerdidos;
	private int pontosTotais;
	private double mediaJogosGanhos;
	private double mediaJogosPerdidos;
	private double mediaPontosTotais;

	public EstatisticasSerie() {
	}

	public EstatisticasSerie(Rodada rodada, int serie) {
		this.rodada = rodada;
		this.serie = serie;
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

	public int getNumeroJogadores() {
		return numeroJogadores;
	}

	public void addNumeroJogadores(int numeroJogadores) {
		this.numeroJogadores += numeroJogadores;
	}

	public int getJogosGanhos() {
		return jogosGanhos;
	}

	public void addJogosGanhos(int jogosGanhos) {
		this.jogosGanhos += jogosGanhos;
	}

	public int getJogosPerdidos() {
		return jogosPerdidos;
	}

	public void addJogosPerdidos(int jogosPerdidos) {
		this.jogosPerdidos += jogosPerdidos;
	}

	public int getPontosTotais() {
		return pontosTotais;
	}

	public void addPontosTotais(int pontosTotais) {
		this.pontosTotais += pontosTotais;
	}

	public double getMediaJogosGanhos() {
		return mediaJogosGanhos;
	}

	public void setMediaJogosGanhos(double mediaJogosGanhos) {
		this.mediaJogosGanhos = mediaJogosGanhos;
	}

	public double getMediaJogosPerdidos() {
		return mediaJogosPerdidos;
	}

	public void setMediaJogosPerdidos(double mediaJogosPerdidos) {
		this.mediaJogosPerdidos = mediaJogosPerdidos;
	}

	public double getMediaPontosTotais() {
		return mediaPontosTotais;
	}

	public void setMediaPontosTotais(double mediaPontosTotais) {
		this.mediaPontosTotais = mediaPontosTotais;
	}

}
