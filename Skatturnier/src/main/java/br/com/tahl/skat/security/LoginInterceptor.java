package br.com.tahl.skat.security;

import javax.inject.Inject;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.com.tahl.skat.controller.LoginController;

@Intercepts
public class LoginInterceptor {

	private Result result;
	private ControllerMethod controllerMethod;
	private JogadorLogado jogadorLogado;

	public LoginInterceptor() {}
	
	@Inject
	public LoginInterceptor(Result result, ControllerMethod controllerMethod, JogadorLogado jogadorLogado) {
		this.result = result;
		this.controllerMethod = controllerMethod;
		this.jogadorLogado = jogadorLogado;
		
	}
	
	@Accepts
	public boolean accept() {
		return !controllerMethod.containsAnnotation(Open.class);
	}
	
	@AroundCall
	public void intercept(SimpleInterceptorStack stack) {
		if (jogadorLogado.isLogado()) {
			stack.next();
		} else {
			result.redirectTo(LoginController.class).form();
		}
	}
}
