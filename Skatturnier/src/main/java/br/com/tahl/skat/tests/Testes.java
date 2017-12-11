package br.com.tahl.skat.tests;

import java.util.Locale;
import java.util.ResourceBundle;

import br.com.tahl.skat.utils.idioma.IdiomaUtils;

public class Testes {

	private static ResourceBundle rb;

	public static void main(String[] args) {
		
		String msg = IdiomaUtils.getTraducao("login.lbl.titulo-aplicacao", "esn");
		
		System.out.println(msg);
	}
}
