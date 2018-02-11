package br.com.tahl.skat.utils;

import java.util.List;

import br.com.tahl.skat.dao.CampeonatoDao;
import br.com.tahl.skat.model.Campeonato;
import br.com.tahl.skat.model.Rodada;

public class CampeonatoUtils {

	private Campeonato campeonato;
	private CampeonatoDao campeonatoDao;
	
	public CampeonatoUtils(Campeonato campeonato, CampeonatoDao campeonatoDao) {
		this.campeonato = campeonato;
		this.campeonatoDao = campeonatoDao;
	}
	
	public Campeonato instanciarRodadas() {
		List<Rodada> rodadas = campeonato.getRodadas();
		if (rodadas.size() > campeonato.getNumeroRodadas()) {
			for (int r = rodadas.size(); r > campeonato.getNumeroRodadas(); r--) {
				rodadas.remove(r);
			}
		} else 	if (rodadas.size() < campeonato.getNumeroRodadas()) {
			for (int r = rodadas.size(); r < campeonato.getNumeroRodadas(); r++) {
				rodadas.add(new Rodada(campeonato, r + 1));
			}
			campeonato.setRodadas(rodadas);
		}
		campeonatoDao.salvar(campeonato);
		return campeonato;
	}
	
	public boolean isNumeroDeRodadasValido() {
		return campeonato.getRodadas().size() == campeonato.getNumeroRodadas();
	}
}
