package br.com.tahl.skat.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.tahl.skat.dao.JogadorDao;
import br.com.tahl.skat.model.Jogador;
import br.com.tahl.skat.security.JogadorLogado;
import br.com.tahl.skat.utils.LoginUtils;

@Controller
public class JogadorController {
	
	private Result result;
	
	private JogadorDao jogadorDao;
	private JogadorLogado jogadorLogado;

	public JogadorController() {}
	
	@Inject
	public JogadorController(Result result, JogadorDao jogadorDao, JogadorLogado jogadorLogado) {
		this.result = result;
		this.jogadorDao = jogadorDao;
		this.jogadorLogado = jogadorLogado;
	}
	
	public void novaSenha() {
		System.out.println(jogadorLogado.getJogador().getNome());
	}
	
	public void gerarNovaSenha(String senhaAtual, String senhaNova, String senhaNovaRepetir) {

		Jogador jogador = jogadorLogado.getJogador();
		
		if (senhaNova.equals(senhaNovaRepetir)) {
			if (LoginUtils.getHash(senhaAtual).equals(jogador.getSenha())) {
				jogador.setSenha(LoginUtils.getHash(senhaNova));
				jogadorDao.salvar(jogador);
			}
		}
		
		result.redirectTo(CampeonatoController.class).listar();
	}
}
