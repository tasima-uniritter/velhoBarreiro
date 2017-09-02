package br.com.velhorbarreiro.evento;

import java.util.Calendar;

import br.com.velhorbarreiro.modelo.Evento;

public class EventoRN {

	public void criar(Evento evento) throws Exception {
		this.verificarNomePreenchido(evento);
		this.verificarDataValidadePreenchida(evento);
		this.verificarTamanhoDoNome(evento);
		this.verificarDataValidadeMenorDataAtual(evento);
	}

	public void verificarNomePreenchido(Evento evento) throws Exception{		
		if(evento.getNome() == null){
			throw new Exception("Informe o Nome.");			
		}
	}
	
	public void verificarTamanhoDoNome(Evento evento) throws Exception{		
		if(evento.getNome().length() > 150){
			throw new Exception("O nome permite no máximo 150 caracteres.");
		}
	}
	
	public void verificarDataValidadePreenchida(Evento evento) throws Exception{		
		if(evento.getDataValidade() == null){
			throw new Exception("Informe a Data de Validade do Evento.");
		}
	}
	
	private void verificarDataValidadeMenorDataAtual(Evento evento) throws Exception {
		if (Calendar.getInstance().after(evento.getDataValidade())){
			throw new Exception("A data do evento deve ser igual ou maior que a de hoje.");
		}
	}
}
