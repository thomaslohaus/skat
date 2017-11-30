package br.com.tahl.skat.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.tahl.skat.model.Campeonato;

@ApplicationScoped
public class CampeonatoDao {

	private EntityManager manager;

	@Inject
	public CampeonatoDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public CampeonatoDao(){}
	
	public Campeonato carregar(int id) {
		return manager.find(Campeonato.class, id);
	}
	
	public Campeonato salvar(Campeonato campeonato) {
		manager.getTransaction().begin();
		
		if (campeonato != null && campeonato.getId() > 0)
			manager.merge(campeonato);
		else
			manager.persist(campeonato);
		
		manager.getTransaction().commit();
		
		return campeonato;
	}
	
	public List<Campeonato> listar() {
		TypedQuery<Campeonato> query = manager.createQuery("select c from Campeonato c", Campeonato.class);
		return query.getResultList();
	}
	
}
