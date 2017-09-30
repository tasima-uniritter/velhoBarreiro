package br.com.velhobarreiro.teste.integration;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.velhobarreiro.teste.desconto.gerenciar.ExecutaGerenciarDescontos;
import br.com.velhobarreiro.teste.evento.criar.ExecutaCriarEvento;
import br.com.velhobarreiro.teste.ingresso.disponibilizar.ExecutaDisponibilizarIngresso;
import br.com.velhobarreiro.teste.ingresso.selecionar.ExecutaSelecionarIngresso;

@RunWith(Suite.class)
@SuiteClasses({
	ExecutaCriarEvento.class,
	ExecutaDisponibilizarIngresso.class,
	ExecutaGerenciarDescontos.class,
	ExecutaSelecionarIngresso.class
})
public class SuiteTest {
	
}

