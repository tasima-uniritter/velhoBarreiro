package br.com.velhorbarreiro.repository.inteface;

import br.com.velhorbarreiro.modelo.abstratos.Entidade;

public interface RepositoryConsulta {

	Entidade consulta(Long id);
}
