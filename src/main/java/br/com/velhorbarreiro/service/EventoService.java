package br.com.velhorbarreiro.service;

import br.com.velhorbarreiro.dto.EventoDTO;
import br.com.velhorbarreiro.modelo.Evento;
import br.com.velhorbarreiro.validation.Validator;
import br.com.velhorbarreiro.validation.evento.EventoValidator;

public class EventoService {

	private EventoDTO eventoDTO;
	
	public EventoService(EventoDTO eventoDTO) {
		this.eventoDTO = eventoDTO;
	}
	
	public void criar() throws Exception {
		Evento evento = new Evento(eventoDTO.getNome(), eventoDTO.getDataValidade());
		Validator validator = new EventoValidator(evento);
		validator.validar();
	}
}
