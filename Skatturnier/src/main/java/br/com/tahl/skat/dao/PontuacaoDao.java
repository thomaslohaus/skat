package br.com.tahl.skat.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.tahl.skat.model.Rodada;
import br.com.tahl.skat.model.Jogador;
import br.com.tahl.skat.model.Pontuacao;

@ApplicationScoped
public class PontuacaoDao {

	private EntityManager manager;

	@Inject
	public PontuacaoDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public PontuacaoDao(){}
	
	public Pontuacao carregar(int id) {
		return manager.find(Pontuacao.class, id);
	}
	
	public Pontuacao salvar(Pontuacao pontuacao) {
		manager.getTransaction().begin();
		
		if (pontuacao != null && pontuacao.getId() > 0)
			manager.merge(pontuacao);
		else
			manager.persist(pontuacao);
		
		manager.getTransaction().commit();
		
		return pontuacao;
	}
	
	public List<Jogador> listarJogadorPorRodada(Rodada rodada) {
		TypedQuery<Jogador> query = manager.createQuery("select distinct p.jogador from Pontuacao p where p.rodada = :rodada", Jogador.class);
		query.setParameter("rodada", rodada);
		return query.getResultList();
	}
	
	public Pontuacao listarPontuacaoPorRodadaSerieJogador(Rodada rodada, int serie, Jogador jogador) {
		TypedQuery<Pontuacao> query = manager.createQuery("select p from Pontuacao p where p.rodada = :rodada and p.serie = :serie and p.jogador = :jogador", Pontuacao.class);
		query.setParameter("rodada", rodada);
		query.setParameter("serie", serie);
		query.setParameter("jogador", jogador);
		return query.getSingleResult();
	}

}
