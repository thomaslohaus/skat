package br.com.tahl.skat.controller;

import java.io.IOException;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.freemarker.Freemarker;
import br.com.caelum.vraptor.simplemail.AsyncMailer;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.tahl.skat.dao.JogadorDao;
import br.com.tahl.skat.model.Jogador;
import br.com.tahl.skat.security.JogadorLogado;
import br.com.tahl.skat.security.LoginSenhaNuloVazioException;
import br.com.tahl.skat.security.Open;
import br.com.tahl.skat.utils.LoginUtils;
import br.com.tahl.skat.utils.idioma.Idioma;
import br.com.tahl.skat.utils.idioma.IdiomaUtils;
import freemarker.template.TemplateException;

@Controller
public class LoginController {
	
	private Result result;
	private HttpServletRequest request;
	private Validator validator;

	
	private JogadorDao jogadorDao;
	private JogadorLogado jogadorLogado;
	private AsyncMailer mailer;
	private Freemarker freemarker;

	public LoginController() {}
	
	@Inject
	public LoginController(Result result, HttpServletRequest request, Validator validator, 
			JogadorDao jogadorDao, JogadorLogado jogadorLogado, AsyncMailer mailer, Freemarker freemarker) {
		this.result = result;
		this.request = request;
		this.validator = validator;
		this.jogadorDao = jogadorDao;
		this.jogadorLogado = jogadorLogado;
		this.mailer = mailer;
		this.freemarker = freemarker;
	}
	
	@Open
	@Path("/")
	public void login() {
		String acceptLanguage = request.getHeader("accept-language");
		Locale locale = IdiomaUtils.getLocalePrincipalAcceptLanguage(acceptLanguage);
		result.redirectTo(this).login(locale.toString().substring(0, 2));
	}
	
	@Open
	@Path(value= {"/login/{idioma}", "/login/{idioma}/"})
	public void login(String idioma) {
		result.include("idioma", idioma);
		result.include("idiomas", Idioma.values());
	}
	
	@Open
	@Path(value= {"/esqueceu-senha/{idioma}", "/esqueceu-senha/{idioma}/"})
	public void esqueceuSenha(String idioma) {
		result.include("idioma", idioma);
	}
	
	@Open
	@Path(value= {"/nova-conta/{idioma}", "/nova-conta/{idioma}/"})
	public void novaConta(String idioma) {
		result.include("idioma", idioma);
	}
	
	@Open
	@Path("/autenticar")
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
				validator.onErrorRedirectTo(this).login();
			}
		} catch (LoginSenhaNuloVazioException e) {
			validator.add(new SimpleMessage("login_campos_vazios", "Login e senha precisam ser preenchidos!"));
			result.include(login);
			validator.onErrorRedirectTo(this).login();
		}
	}
	
	@Open
	@Path("/deslogar")
	public void deslogar() {
		Idioma idioma = jogadorLogado.getJogador().getIdioma();
		jogadorLogado.desloga();
		if (idioma == null)
			idioma = Idioma.getIdiomaPadrao();
		result.redirectTo(this).login(idioma.getSigla());
	}
	
	@Open
	@Path("/enviarNovaSenha")
	public void enviarNovaSenha(String login, String tipo, String idioma) throws EmailException, IOException, TemplateException {
	
		//TODO encapsular envio
		Jogador jogador = jogadorDao.obterPorLogin(login);
		if (jogador != null) {
			String emailAddress = jogador.getEmail();
			if (emailAddress != null && !emailAddress.trim().isEmpty()) {

				String emailBody = freemarker.use("teste").with("title", "TESTE").with("usuario", jogador).getContent();
				
				HtmlEmail email = new HtmlEmail();
				email.setSubject("Skat || Nova Senha");
				email.addTo(emailAddress);
				email.setHtmlMsg(emailBody);
				mailer.asyncSend(email);
				
				

				result.include("mensagemNovaSenha", "Nova senha enviada por e-mail.");
				result.redirectTo(this).login();
			} else {
				//TODO
			}
		} else {
		//TODO	
		}
	}
}
