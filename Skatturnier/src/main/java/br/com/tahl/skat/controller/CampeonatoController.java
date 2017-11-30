package br.com.tahl.skat.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.tahl.skat.dao.CampeonatoDao;
import br.com.tahl.skat.dao.JogadorDao;
import br.com.tahl.skat.model.Campeonato;
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

	public CampeonatoController() {
	}

	@Inject
	public CampeonatoController(Result result, JogadorDao jogadorDao, CampeonatoDao campeonatoDao) {
		this.result = result;
		this.jogadorDao = jogadorDao;
		this.campeonatoDao = campeonatoDao;
	}
	
	@Path(value= {"/campeonatos", "/campeonatos/"})
	public void listar() {
		result.include("campeonatos", campeonatoDao.listar());
	}

	@Path(value= {"/campeonato/editar/{id}/", "/campeonato/editar/{id}", "/campeonato/editar/", "/campeonato/editar"})
	public void editar(int id) {
		result.include("campeonato", campeonatoDao.carregar(id));
	}
	
	public void salvar(Campeonato campeonato) {
		campeonatoDao.salvar(campeonato);
		result.redirectTo(this).listar();
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
		CampeonatoUtils utils = new CampeonatoUtils(campeonato);
		if (!utils.isNumeroDeRodadasValido()) {
			campeonato = utils.instanciarRodadas();
			campeonatoDao.salvar(campeonato);
		}
		result.include("campeonato", campeonato);
	}
	

}
