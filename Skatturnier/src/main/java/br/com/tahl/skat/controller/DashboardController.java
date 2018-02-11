package br.com.tahl.skat.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;

/**
 * Controller do dashboard e página inicial.
 * 
 * @author Thomas Lohaus
 *
 */
@Controller
public class DashboardController {

	private Result result;

	public DashboardController() {
	}

	@Inject
	public DashboardController(Result result) {
		this.result = result;
	}
}
