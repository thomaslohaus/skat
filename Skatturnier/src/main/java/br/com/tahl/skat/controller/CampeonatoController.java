package br.com.tahl.skat.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.tahl.skat.dao.CampeonatoDao;
import br.com.tahl.skat.dao.JogadorDao;
import br.com.tahl.skat.dao.RodadaDao;
import br.com.tahl.skat.model.Campeonato;
import br.com.tahl.skat.model.Rodada;
import br.com.tahl.skat.utils.CampeonatoUtils;

/**
 * Controller de um campeonato.
 * 
 * @author Thomas Lohaus
 *
 */
@Controller
public class CampeonatoController {

	private Result result;
	private JogadorDao jogadorDao;
	private CampeonatoDao campeonatoDao;
	private RodadaDao rodadaDao;

	public CampeonatoController() {
	}

	@Inject
	public CampeonatoController(Result result, JogadorDao jogadorDao, CampeonatoDao campeonatoDao, RodadaDao rodadaDao) {
		this.result = result;
		this.jogadorDao = jogadorDao;
		this.campeonatoDao = campeonatoDao;
		this.rodadaDao = rodadaDao;
	}
	
	@Path(value= {"/campeonatos", "/campeonatos/"})
	public void listar() {
		result.include("campeonatos", campeonatoDao.listar());
	}

	@Path(value= {"/campeonato/novo/", "/campeonato/novo"})
	public void novo() {
		result.redirectTo(this).info(0);
	}
	
	@Path(value= {"/campeonato/info/{id}/", "/campeonato/info/{id}"})
	public void info(int id) {
		if (id > 0)
			result.include("campeonato", campeonatoDao.carregar(id));
	}
	
	public void salvar(Campeonato campeonato, String tipo) {
		if (tipo.equals("salvar")) {
			for (Rodada rodada : campeonato.getRodadas()) {
				rodada.setCampeonato(campeonato);
			}
			campeonatoDao.salvar(campeonato);
			result.redirectTo(this).listar();
		} else if (tipo.equals("rodada")) {
			result.include("campeonato", campeonato);
			result.redirectTo(this).info(0);
		}
	}
	
	@Path(value= {"/campeonato", "/campeonato/"})
	public void campeonato() {
		result.include("jogadores", jogadorDao.listar());
	}
	
	@Get("/campeonato/incluirJogador")
	public void incluirJogador(int idJogador) {
		result.use(Results.json()).withoutRoot().from(jogadorDao.carregar(idJogador)).serialize();
	}
	
	@Path(value= {"/campeonato/gerenciar/{id}/", "/campeonato/gerenciar/{id}"})
	public void gerenciar(int id) {
		Campeonato campeonato = campeonatoDao.carregar(id);
		CampeonatoUtils utils = new CampeonatoUtils(campeonato, campeonatoDao);
		if (!utils.isNumeroDeRodadasValido()) {
			campeonato = utils.instanciarRodadas();
		}
		result.include("campeonato", campeonato);
	}
}
