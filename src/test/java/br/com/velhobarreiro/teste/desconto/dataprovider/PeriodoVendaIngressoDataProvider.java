package br.com.velhobarreiro.teste.desconto.dataprovider;

import java.util.ArrayList;
import java.util.Calendar;

import br.com.velhorbarreiro.builder.BuilderPeriodoVendaIngresso;
import br.com.velhorbarreiro.enums.CategoriaIngressoEnum;
import br.com.velhorbarreiro.modelo.Evento;
import br.com.velhorbarreiro.modelo.PeriodoVendaIngresso;
import br.com.velhorbarreiro.modelo.PeriodoVendaIngressoCategoriaIngresso;
import br.com.velhorbarreiro.repository.gerenciador.GerenciadorEntidade;

public class PeriodoVendaIngressoDataProvider {

	public PeriodoVendaIngresso criar() throws Exception {
		Evento evento = new EventoDataProvider().criar();
		
		PeriodoVendaIngresso periodoVendaIngresso = new BuilderPeriodoVendaIngresso()
				.paraEvento(evento)
				.comDataInicio(Calendar.getInstance())
				.comDataFim(Calendar.getInstance())
				.criar();
		
		
		GerenciadorEntidade gp = new GerenciadorEntidade();
		gp.incluir(periodoVendaIngresso);
		return periodoVendaIngresso;
	}

	public PeriodoVendaIngresso criar(CategoriaIngressoEnum categoriaIngressoEnum) throws Exception {
		PeriodoVendaIngresso periodoVendaIngresso = criar();
		PeriodoVendaIngressoCategoriaIngresso periodoCategoria = new PeriodoVendaIngressoCategoriaIngresso(periodoVendaIngresso, categoriaIngressoEnum);
		GerenciadorEntidade gerenciador = new GerenciadorEntidade();
		gerenciador.incluir(periodoCategoria);
		periodoVendaIngresso.setListaCategoriaIngresso(new ArrayList<>());
		periodoVendaIngresso.getListaCategoriaIngresso().add(periodoCategoria);
		gerenciador.getEntityManager().merge(periodoVendaIngresso);
		return periodoVendaIngresso;
	}
}
