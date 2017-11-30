package br.com.tahl.skat.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Rodada {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Campeonato campeonato;
	private int numero;
	private int numeroSeries;
	private Calendar data;
	private String local;
	@Enumerated(EnumType.STRING)
	private StatusRodada status;

	public Rodada() {
		this.status = StatusRodada.PENDENTE;
	}

	public Rodada(Campeonato campeonato, int numero) {
		this();
		this.campeonato = campeonato;
		this.numero = numero;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNumeroSeries() {
		return numeroSeries;
	}

	public void setNumeroSeries(int numeroSeries) {
		this.numeroSeries = numeroSeries;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public StatusRodada getStatus() {
		return status;
	}
	
	public void setStatus(StatusRodada status) {
		this.status = status;
	}
}
