package br.com.tahl.skat.utils;

import java.util.List;

import br.com.tahl.skat.model.Campeonato;
import br.com.tahl.skat.model.Rodada;

public class CampeonatoUtils {

	private Campeonato campeonato;
	
	public CampeonatoUtils(Campeonato campeonato) {
		this.campeonato = campeonato;
	}
	
	public Campeonato instanciarRodadas() {
		
		List<Rodada> rodadas = campeonato.getRodadas();
		
		if (rodadas.size() > campeonato.getNumeroRodadas()) {
			campeonato.setNumeroRodadas(rodadas.size());
		}
		else if (rodadas.size() < campeonato.getNumeroRodadas()) {
			for (int r = rodadas.size(); r < campeonato.getNumeroRodadas(); r++) {
				rodadas.add(new Rodada(campeonato, r + 1));
			}
			
			campeonato.setRodadas(rodadas);
		}
		return campeonato;
	}
	
	public boolean isNumeroDeRodadasValido() {
		return campeonato.getRodadas().size() == campeonato.getNumeroRodadas();
	}
}
