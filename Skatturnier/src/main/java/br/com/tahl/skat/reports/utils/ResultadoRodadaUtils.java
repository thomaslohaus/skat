package br.com.tahl.skat.reports.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import br.com.tahl.skat.dao.PontuacaoDao;
import br.com.tahl.skat.model.Jogador;
import br.com.tahl.skat.model.Pontuacao;
import br.com.tahl.skat.model.Rodada;
import br.com.tahl.skat.reports.EstatisticasSerie;
import br.com.tahl.skat.reports.ResultadoRodadaJogador;
import br.com.tahl.skat.utils.PontosComparator;

public class ResultadoRodadaUtils {
	
	private List<Jogador> jogadores;
	private List<ResultadoRodadaJogador> resultados;
	private List<EstatisticasSerie> estatisticas;

	private PontuacaoDao dao;
	
	@Inject
	public ResultadoRodadaUtils (PontuacaoDao pontuacaoDao) {
		this.dao = pontuacaoDao;
		this.resultados = new ArrayList<ResultadoRodadaJogador>();
		this.estatisticas = new ArrayList<EstatisticasSerie>();
	}
	
	public List<ResultadoRodadaJogador> compilarPontuacao(Rodada rodada) {
		for (int serie = 1; serie <= rodada.getNumeroSeries(); serie ++) {
			estatisticas.add(new EstatisticasSerie(rodada, serie));
		}
		
		jogadores = dao.listarJogadorPorRodada(rodada);
		for (Jogador jogador : jogadores) {
			ResultadoRodadaJogador rr = new ResultadoRodadaJogador(rodada, jogador);
			for (int serie = 1; serie <= rodada.getNumeroSeries(); serie ++) {
				Pontuacao pontuacao = dao.listarPontuacaoPorRodadaSerieJogador(rodada, serie, jogador);
				
				if (pontuacao != null) {
					incluirEstatisticas(serie, pontuacao);
				}
				
				rr.adicionarSerie(pontuacao);
				rr.setPontosTotais(rr.getPontosTotais() + pontuacao.getPontosTotais());
			}
			resultados.add(rr);
		}
		
		estatisticas = calcularMedias(estatisticas);
		
		Collections.sort(resultados, new PontosComparator());
		
		for (int c = 0; c < resultados.size(); c++) {
			resultados.get(c).setClassificacao(c + 1);
		}
		
		return resultados;
	}

	private void incluirEstatisticas(int serie, Pontuacao pontuacao) {
		estatisticas.get(serie - 1).addNumeroJogadores(1);
		estatisticas.get(serie - 1).addJogosGanhos(pontuacao.getJogosGanhos());
		estatisticas.get(serie - 1).addJogosPerdidos(pontuacao.getJogosPerdidos());
		estatisticas.get(serie - 1).addPontosTotais(pontuacao.getPontosTotais());
	}
	
	private List<EstatisticasSerie> calcularMedias(List<EstatisticasSerie> estatisticas) {
		for (EstatisticasSerie estatisticasSerie : estatisticas) {
			double numeroJogadores = estatisticasSerie.getNumeroJogadores() * 1.0;
			
			estatisticasSerie.setMediaJogosGanhos(estatisticasSerie.getJogosGanhos() / numeroJogadores);
			estatisticasSerie.setMediaJogosPerdidos(estatisticasSerie.getJogosPerdidos() / numeroJogadores);
			estatisticasSerie.setMediaPontosTotais(estatisticasSerie.getPontosTotais() / numeroJogadores);
		}
		return estatisticas;
	}
	
	public List<EstatisticasSerie> getEstatisticas() {
		return estatisticas;
	}
}
