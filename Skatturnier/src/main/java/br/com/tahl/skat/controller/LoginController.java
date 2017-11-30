package br.com.tahl.skat.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.tahl.skat.dao.JogadorDao;
import br.com.tahl.skat.model.Jogador;
import br.com.tahl.skat.security.JogadorLogado;
import br.com.tahl.skat.security.LoginSenhaNuloVazioException;
import br.com.tahl.skat.security.Open;
import br.com.tahl.skat.utils.LoginUtils;

@Controller
public class LoginController {
	
	private Result result;
	private Validator validator;
	
	private JogadorDao jogadorDao;
	private JogadorLogado jogadorLogado;

	public LoginController() {}
	
	@Inject
	public LoginController(Result result, Validator validator, JogadorDao jogadorDao, JogadorLogado jogadorLogado) {
		this.result = result;
		this.validator = validator;
		this.jogadorDao = jogadorDao;
		this.jogadorLogado = jogadorLogado;
	}
	
	@Open
	@Path("/")
	public void form() {}
	
	@Open
	public void autenticar(String login, String senha) {
		try {
			if (login == null || login.trim().equals("") ||
				senha == null || senha.trim().equals(""))
				throw new LoginSenhaNuloVazioException();
			
			String senhaHash = LoginUtils.getHash(senha);
			
			Jogador jogador = jogadorDao.login(login, senhaHash);
			if (jogador != null) {
				jogadorLogado.fazLogin(jogador);
				result.redirectTo(CampeonatoController.class).listar();
			} else {
				validator.add(new SimpleMessage("login_invalido", "Login ou senha inválidos!"));
				result.include(login);
				validator.onErrorRedirectTo(this).form();
			}
		} catch (LoginSenhaNuloVazioException e) {
			validator.add(new SimpleMessage("login_campos_vazios", "Login e senha precisam ser preenchidos!"));
			result.include(login);
			validator.onErrorRedirectTo(this).form();
		}
		
		
	}
	
	@Open
	public void deslogar() {
		jogadorLogado.desloga();
		result.redirectTo(this).form();
	}
}
