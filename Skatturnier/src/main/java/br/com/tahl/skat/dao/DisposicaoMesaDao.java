package br.com.tahl.skat.dao;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.tahl.skat.model.DisposicaoMesa;

@ApplicationScoped
public class DisposicaoMesaDao {

	private EntityManager manager;

	@Inject
	public DisposicaoMesaDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public DisposicaoMesaDao(){}
	
	public DisposicaoMesa carregar(int id) {
		return manager.find(DisposicaoMesa.class, id);
	}
	
	public DisposicaoMesa salvar(DisposicaoMesa disposicaoMesa) {
		manager.getTransaction().begin();
		
		if (disposicaoMesa != null && disposicaoMesa.getId() > 0)
			manager.merge(disposicaoMesa);
		else
			manager.persist(disposicaoMesa);
		
		manager.getTransaction().commit();
		
		return disposicaoMesa;
	}
}
