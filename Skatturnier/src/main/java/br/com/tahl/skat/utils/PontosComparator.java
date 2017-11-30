package br.com.tahl.skat.utils;

import java.util.Comparator;

public class PontosComparator implements Comparator<Pontos> {

	@Override
	public int compare(Pontos p1, Pontos p2) {
		if (p1.getPontosTotais() < p2.getPontosTotais())
			return 1;
		else if (p1.getPontosTotais() > p2.getPontosTotais())
			return -1;
		else
			return 0;
	}

}
