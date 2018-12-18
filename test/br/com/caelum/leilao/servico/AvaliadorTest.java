package br.com.caelum.leilao.servico;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;

public class AvaliadorTest {

	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		// parte 1: cenario
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");
		Usuario rico = new Usuario("Rico");

		Leilao leilao = new Leilao("Playstation 3 novo.");

		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));
		leilao.propoe(new Lance(maria, 250.0));
		leilao.propoe(new Lance(rico, 10000.0));

		// parte 2: acao
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		// parte 3: validacao
		double maiorEsperado = 400;
		double menorEsperado = 250;
		double lanceLimite = 10000;
		double mediaLance = 2737.5;

		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(menorEsperado, leiloeiro.getMenorDeTodos(), 0.00001);
		assertEquals(lanceLimite, leiloeiro.getLanceLimite(), 0.00001);
		assertEquals(mediaLance, leiloeiro.getMediaLance(), 0.00001);

	}

}
