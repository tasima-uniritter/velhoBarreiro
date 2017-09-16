package br.com.velhorbarreiro.validation.evento;

import java.util.Calendar;

import br.com.velhorbarreiro.modelo.Evento;
import br.com.velhorbarreiro.util.CalendarUtil;

public class EventoValidator {

	public EventoValidator() {
	}

	
	public void validar(Evento evento) throws Exception {
		validarDataValidadaNaoPodeSerPassada(evento);
	}

	private void validarDataValidadaNaoPodeSerPassada(Evento evento) throws Exception {
		Calendar dataAtual = Calendar.getInstance();
		CalendarUtil.setInicioDia(dataAtual);
		if (evento.getDataValidade().before(dataAtual)) {
			throw new Exception("A data do evento deve ser igual ou maior que a de hoje.");
		}
	}

}
