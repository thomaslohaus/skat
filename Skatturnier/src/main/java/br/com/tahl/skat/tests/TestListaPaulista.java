package br.com.tahl.skat.tests;

import java.util.ArrayList;
import java.util.List;

import br.com.tahl.skat.model.DisposicaoMesa;
import br.com.tahl.skat.model.Jogador;
import br.com.tahl.skat.utils.GeradorMesas;
import br.com.tahl.skat.utils.NumeroDeJogadoresException;

public class TestListaPaulista {

	public static void main(String[] args) throws NumeroDeJogadoresException {
		List<Jogador> jogadores = new ArrayList<Jogador>();
		jogadores.add(new Jogador("Anibal Chaim"));
		jogadores.add(new Jogador("Annelie Panse"));
		jogadores.add(new Jogador("Baerbel Schroeter"));
		jogadores.add(new Jogador("Dieter Schober"));
		jogadores.add(new Jogador("Gerd Abeling"));
		jogadores.add(new Jogador("Gunther Brunckhorst"));
		jogadores.add(new Jogador("Hans Reist"));
		jogadores.add(new Jogador("Harald Brunckhorst"));
		jogadores.add(new Jogador("Harald Helbig"));
		jogadores.add(new Jogador("Harald Jeromin"));
		jogadores.add(new Jogador("Heinrich Borgert"));/*
		jogadores.add(new Jogador("Heinz Feldenheimer"));
		jogadores.add(new Jogador("Henrique Waack"));
		jogadores.add(new Jogador("Inga Kirsten"));
		jogadores.add(new Jogador("Ingo Selke"));
		jogadores.add(new Jogador("Irene Heying"));
		jogadores.add(new Jogador("Leo Kloekler"));
		jogadores.add(new Jogador("Matthias Neisser"));
		jogadores.add(new Jogador("Paul Heinritz"));
		jogadores.add(new Jogador("Peter Haas"));
		jogadores.add(new Jogador("Rainer Kedor"));
		jogadores.add(new Jogador("Rainer Theuer"));
		jogadores.add(new Jogador("Ricardo Kohara"));
		jogadores.add(new Jogador("Robin Hermans"));
		jogadores.add(new Jogador("Roland Helmer"));
		jogadores.add(new Jogador("Thomas Lohaus"));
		jogadores.add(new Jogador("Willi Heying"));
		*/
		
		for (DisposicaoMesa dispMesa : GeradorMesas.gerarMesas(jogadores)) {
			System.out.println(dispMesa);
		}
	}
	
	
}

