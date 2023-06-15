package entities;

public final class PessoaJuridica extends Contribuinte{ // Herança.
	
	private int numeroDeFuncionarios;
	
	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String nome, Double rendaAnual, int numeroDeFuncionarios) {
		super(nome, rendaAnual);
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}


	public int getNumeroDeFuncionarios() {
		return numeroDeFuncionarios;
	}

	public void setNumeroDeFuncionarios(int numeroDeFuncionarios) {
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}

	@Override
	public final Double impostoAPagar() { // Polimorfismo aqui e implementação do método abstrato.
		if (numeroDeFuncionarios <= 10) {
			return getRendaAnual() * 0.16; 
		} else {						
			return getRendaAnual() * 0.14;	
		}
	}
}
