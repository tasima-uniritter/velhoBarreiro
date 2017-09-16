package br.com.velhorbarreiro.modelo.abstratos;

public abstract class Cliente {
	
	private Double valorPago;

	public abstract void calcularDesconto(Double valorEvento);

	public Double getValorPago() {
		return valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}	
}
