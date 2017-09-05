package br.com.velhorbarreiro.validation.evento;

import java.util.Calendar;

import br.com.velhorbarreiro.modelo.Evento;
import br.com.velhorbarreiro.validation.Validator;

public class EventoValidator implements Validator {

	private Evento evento;

	public EventoValidator(Evento evento) {
		this.evento = evento;
	}

	@Override
	public void validar() throws Exception {
		validarDataValidadaNaoPodeSerPassada();
	}

	private void validarDataValidadaNaoPodeSerPassada() throws Exception {
		if (evento.getDataValidade().before(Calendar.getInstance())) {
			throw new Exception("A data do evento deve ser igual ou maior que a de hoje.");
		}
	}

}
