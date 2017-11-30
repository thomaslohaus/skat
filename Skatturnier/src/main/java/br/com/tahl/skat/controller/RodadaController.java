package br.com.tahl.skat.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.tahl.skat.dao.RodadaDao;
import br.com.tahl.skat.model.Rodada;
import br.com.tahl.skat.reports.EstatisticasSerie;
import br.com.tahl.skat.reports.ResultadoRodadaJogador;
import br.com.tahl.skat.reports.utils.ResultadoRodadaUtils;

/**
 * Controller de uma rodada de um campeonato.
 * 
 * @author Thomas Lohaus
 *
 */
@Controller
public class RodadaController {

	private Result result;
	private RodadaDao rodadaDao;
	private ResultadoRodadaUtils resultadoRodadaUtils;

	public RodadaController() {
	}

	@Inject
	public RodadaController(Result result, RodadaDao rodadaDao, ResultadoRodadaUtils resultadoRodadaUtils) {
		this.result = result;
		this.rodadaDao = rodadaDao;
		this.resultadoRodadaUtils = resultadoRodadaUtils;
	}
	
	@Path(value= {"/rodada/resultados/{id}", "/rodada/resultados/{id}/"})
	public void resultados(int id) {
		Rodada rodada = rodadaDao.carregar(id);
		result.include("rodada", rodada);
		
		List<ResultadoRodadaJogador> resultadosRodadaJogador = resultadoRodadaUtils.compilarPontuacao(rodada);
		List<EstatisticasSerie> estatisticas = resultadoRodadaUtils.getEstatisticas();
		
		result.include("resultadosRodadaJogador", resultadosRodadaJogador);
		result.include("estatisticasRodada", estatisticas);
	}
	
	@Path(value= {"/rodada/dashboard/{id}", "/rodada/dashboard/{id}/"})
	public void dashboard(int id) {
		
	}

}
