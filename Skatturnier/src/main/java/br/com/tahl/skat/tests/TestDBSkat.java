package br.com.tahl.skat.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tahl.skat.dao.CampeonatoDao;
import br.com.tahl.skat.model.Campeonato;
import br.com.tahl.skat.model.Rodada;
import br.com.tahl.skat.security.LoginSenhaNuloVazioException;

public class TestDBSkat {

	public static void main(String[] args) throws LoginSenhaNuloVazioException {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		EntityManager manager = factory.createEntityManager();

		CampeonatoDao campeonatoDao = new CampeonatoDao(manager);
		
		Campeonato campeonato = campeonatoDao.carregar(1);
		
		for (Rodada rodada : campeonato.getRodadas()) {
			System.out.println(rodada.getId());
		}
		
		System.out.println("FIM");
		
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
