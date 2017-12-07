package br.com.tahl.skat.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.tahl.skat.model.Jogador;

@ApplicationScoped
public class JogadorDao {

	private EntityManager manager;

	@Inject
	public JogadorDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public JogadorDao(){}
	
	public Jogador carregar(int id) {
		return manager.find(Jogador.class, id);
	}
	
	public Jogador salvar(Jogador jogador) {
		manager.getTransaction().begin();
		
		if (jogador != null && jogador.getId() > 0)
			manager.merge(jogador);
		else
			manager.persist(jogador);
		
		manager.getTransaction().commit();
		
		return jogador;
	}
	
	public List<Jogador> listar() {
		TypedQuery<Jogador> query = manager.createQuery("select j from Jogador j", Jogador.class);
		return query.getResultList();
	}

	public Jogador login(String login, String senha) {
		try {
			TypedQuery<Jogador> query = manager.createQuery("select j from Jogador j where (j.login = :login or j.email = :loginEmail) and j.senha = :senha ", Jogador.class);
			query.setParameter("login", login);
			query.setParameter("loginEmail", login);
			query.setParameter("senha", senha);
			return query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}
	
	public Jogador obterPorLogin(String login) {
		try {
			TypedQuery<Jogador> query = manager.createQuery("select j from Jogador j where (j.login = :login or j.email = :loginEmail)", Jogador.class);
			query.setParameter("login", login);
			query.setParameter("loginEmail", login);
			return query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}
}
