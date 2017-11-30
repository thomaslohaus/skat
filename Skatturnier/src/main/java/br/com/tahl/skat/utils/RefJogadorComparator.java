package br.com.tahl.skat.utils;

import java.util.Comparator;

public class RefJogadorComparator implements Comparator<RefJogador> {

	@Override
	public int compare(RefJogador j1, RefJogador j2) {
		return j1.getJogador().getNome().compareTo(j2.getJogador().getNome());
	}

}
