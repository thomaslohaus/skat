package br.com.tahl.skat.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.tahl.skat.model.Campeonato;
import br.com.tahl.skat.model.Rodada;

@ApplicationScoped
public class RodadaDao {

	private EntityManager manager;

	@Inject
	public RodadaDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public RodadaDao(){}
	
	public Rodada carregar(int id) {
		return manager.find(Rodada.class, id);
	}
	
	public Rodada salvar(Rodada rodada) {
		manager.getTransaction().begin();
		
		if (rodada != null && rodada.getId() > 0)
			manager.merge(rodada);
		else
			manager.persist(rodada);
		
		manager.getTransaction().commit();
		
		return rodada;
	}
	
	public Rodada carregarPorNumero(int numero) {
		TypedQuery<Rodada> query = manager.createQuery("select r from Rodada r where r.numero = :numero", Rodada.class);
		query.setParameter("numero", numero);
		return query.getSingleResult();
	}
	
	public List<Rodada> listarPorCampeonato(Campeonato campeonato) {
		TypedQuery<Rodada> query = manager.createQuery("select r from Rodada r where r.campeonato = :campeonato", Rodada.class);
		query.setParameter("campeonato", campeonato);
		return query.getResultList();
	}
}
