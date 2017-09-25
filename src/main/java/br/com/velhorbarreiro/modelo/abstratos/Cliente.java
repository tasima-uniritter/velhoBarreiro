package br.com.velhorbarreiro.modelo.abstratos;

public abstract class Cliente {

	protected Double percentualDesconto;
	private Double valorPago;

	public void calcularDesconto(Double valorEvento) {
		valorPago = (valorEvento * percentualDesconto);
	}
	
	public Double getPercentualDesconto() {
		return percentualDesconto;
	}

	public Double getValorPago() {
		return valorPago;
	}
}
