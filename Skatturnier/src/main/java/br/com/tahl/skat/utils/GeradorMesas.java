package br.com.tahl.skat.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.tahl.skat.model.DisposicaoMesa;
import br.com.tahl.skat.model.Jogador;
import br.com.tahl.skat.model.Posicao;
import br.com.tahl.skat.model.Rodada;

public class GeradorMesas {

	public static List<DisposicaoMesa> gerarMesas(List<Jogador> jogadores) throws NumeroDeJogadoresException {
		
		if (jogadores.size() < 3 || jogadores.size() == 5)
			throw new NumeroDeJogadoresException(jogadores.size());
		
		Collections.shuffle(jogadores);
		
		int mesas3 = quantidadeMesas3(jogadores.size());
		int mesas4 = quantidadeMesas4(jogadores.size());
		
		System.out.println("Jogadores: " + jogadores.size() + " | Mesas 4: " + mesas4 + " | Mesas 3: " + mesas3);
		
		List<DisposicaoMesa> mesas = new ArrayList<DisposicaoMesa>();
		
		Rodada rodada = new Rodada();
		int serie = 1;
		
		int j = 0;
		Posicao[] posicoes = Posicao.posicoes4Jogadores();
		for (int mesa = 1; mesa <= mesas3 + mesas4; mesa++) {
			if (mesa == mesas4 + 1) {
				posicoes = Posicao.posicoes3Jogadores();
			}
			for (Posicao posicao : posicoes) {
				mesas.add(new DisposicaoMesa(rodada, serie, mesa, posicao, jogadores.get(j++)));
			}
		}
		
		return mesas;
	}
	
	private static int quantidadeMesas4(int quantidadeJogadores) {
		int mesas4jogadores = (quantidadeJogadores - (quantidadeMesas3(quantidadeJogadores) * 3))/4;
		return mesas4jogadores;
	}

	public static int quantidadeMesas3(int quantidadeJogadores) {
		int mesas3jogadores = 4-(quantidadeJogadores % 4);
		mesas3jogadores = mesas3jogadores == 4 ? 0 : mesas3jogadores;
		return mesas3jogadores;
		
	}
}
