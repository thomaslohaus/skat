package br.com.tahl.skat.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "rodada_id", "serie", "mesa", "posicao" }) })
public class DisposicaoMesa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Rodada rodada;
	private int serie;
	private int mesa;
	@Enumerated(EnumType.STRING)
	private Posicao posicao;
	@ManyToOne
	private Jogador jogador;

	public DisposicaoMesa() {}
	
	public DisposicaoMesa(Rodada rodada, int serie, int mesa, Posicao posicao, Jogador jogador) {
		this.rodada = rodada;
		this.serie = serie;
		this.mesa = mesa;
		this.posicao = posicao;
		this.jogador = jogador;
	}

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
	
	public int getMesa() {
		return mesa;
	}

	public void setMesa(int mesa) {
		this.mesa = mesa;
	}

	public Posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	@Override
	public String toString() {
		return "Rodada: " + rodada.getNumero() + " | Serie: " + serie + " | Mesa: " + mesa + posicao + " | Jogador: " + jogador.getNome();
	}
}
