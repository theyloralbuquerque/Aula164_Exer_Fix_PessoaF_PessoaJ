package entities;

public final class PessoaFisica extends Contribuinte{ // Herança.

	private Double gastosComSaude;

	public PessoaFisica() {
		super();
	}
	
	public PessoaFisica(String nome, Double rendaAnual, Double gastosComSaude) {
		super(nome, rendaAnual);
		this.gastosComSaude = gastosComSaude;
	}
	
	public Double getGastosComSaude() {
		return gastosComSaude;
	}

	public void setGastosComSaude(Double gastosComSaude) {
		this.gastosComSaude = gastosComSaude;
	}

	@Override
	public final Double impostoAPagar() { // Polimorfismo aqui e implementação do método abstrato.
		if (getRendaAnual() < 20000.00) {
			return (getRendaAnual() * 0.15) - (gastosComSaude * 0.50);
		} else {
			return (getRendaAnual() * 0.25) - (gastosComSaude * 0.50);
		}
	}
}
