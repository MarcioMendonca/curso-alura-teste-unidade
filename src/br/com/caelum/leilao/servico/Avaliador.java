package br.com.caelum.leilao.servico;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class Avaliador {

	private double maiorDeTodos = Double.NEGATIVE_INFINITY;
	private double menorDeTodos = Double.POSITIVE_INFINITY;
	private double lanceLimite = 10000;

	public void avalia(Leilao leilao) {

		for (Lance lance : leilao.getLances()) {
			if (lance.getValor() == lanceLimite) {
				this.lanceLimite = lance.getValor();				
			} else {
				if (lance.getValor() > maiorDeTodos)
					maiorDeTodos = lance.getValor();
				if (lance.getValor() < menorDeTodos)
					menorDeTodos = lance.getValor();
			}
		}
	}

	public double getLanceLimite() {
		return lanceLimite;
	}
	
	public double getMaiorLance() {
		return maiorDeTodos;
	}

	public double getMenorDeTodos() {
		return menorDeTodos;
	}

}
