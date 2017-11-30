package br.com.tahl.skat.tests;

import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tahl.skat.security.LoginSenhaNuloVazioException;
import br.com.tahl.skat.utils.LoginUtils;

public class TestDBSkat {

	public static void main(String[] args) throws LoginSenhaNuloVazioException {
		/*
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		EntityManager manager = factory.createEntityManager();

		
		manager.close();
		factory.close();
		
		*/
		
		String password = "thomas";
		
		System.out.println(LoginUtils.getHash(password));
		
		System.out.println(LoginUtils.generatePassword());
		
	}
	
	
	public static void quantidadeMesas() {

		int j = 27;
		int m3 = 4-(j%4);
		m3 = m3 == 4 ? 0 : m3;
		int m4 = (j - (m3 * 3))/4;
		System.out.println(m3 + " - " + m4);
		
	}
}
