package br.com.velhorbarreiro.enums;

public enum CategoriaIngressoEnum {

	VIP(1, "Vip", 1000.00),
	BACKSTAGE(2, "Backstage", 800.00),
	PLATEIA_VIP(3, "Plateia Vip", 500.00),
	PLATEIA(4, "Platéia", 300.00);

	private Integer codigo;
	private String descricao;
	private Double valor;

	private CategoriaIngressoEnum(Integer codigo, String descricao, Double valor) {
		this.codigo =codigo;
		this.descricao = descricao;
		this.valor = valor;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public Double getValor() {
		return valor;
	}
}
