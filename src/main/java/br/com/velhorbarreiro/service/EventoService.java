package br.com.velhorbarreiro.service;

import br.com.velhorbarreiro.dto.EventoDTO;
import br.com.velhorbarreiro.fabrica.FabricaEvento;
import br.com.velhorbarreiro.modelo.Evento;
import br.com.velhorbarreiro.repository.EventoRepository;
import br.com.velhorbarreiro.repository.inteface.RepositoryInclusao;
import br.com.velhorbarreiro.validation.evento.EventoValidator;

public class EventoService {

	public EventoService() {

	}

	public Evento incluir(EventoDTO eventoDTO) throws Exception {
		Evento evento = FabricaEvento.criar(eventoDTO.getNome(), eventoDTO.getDataValidade());
		EventoValidator validator = new EventoValidator();
		validator.validar(evento);
		RepositoryInclusao eventoRepository = new EventoRepository();
		eventoRepository.inclui(evento);
		return evento;
	}
}
