package br.com.tahl.skat.tests;

import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tahl.skat.dao.JogadorDao;
import br.com.tahl.skat.model.Jogador;
import br.com.tahl.skat.security.LoginSenhaNuloVazioException;
import br.com.tahl.skat.utils.LanguageUtils;
import br.com.tahl.skat.utils.LoginUtils;

public class TestDBSkat {

	public static void main(String[] args) throws LoginSenhaNuloVazioException {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		EntityManager manager = factory.createEntityManager();

		Locale[] l = LanguageUtils.getLocaleFromAcceptLanguage("pt-BR,pt;q=0.9,en-US;q=0.8,en;q=0.7,de-DE;q=0.6,de;q=0.5,de-CH;q=0.4");
		
		for (Locale locale : l) {
			System.out.println(locale.getLanguage());
		}
		
		manager.close();
		factory.close();
		
	}
	
	
	public static void quantidadeMesas() {

		int j = 27;
		int m3 = 4-(j%4);
		m3 = m3 == 4 ? 0 : m3;
		int m4 = (j - (m3 * 3))/4;
		System.out.println(m3 + " - " + m4);
		
	}
}
