package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contribuinte;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List <Contribuinte> list = new ArrayList<>(); // Lista do tipo genérico (superclasse).
		
		System.out.print("Digite o número de contribuintes: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println();
			System.out.printf("Digite os dados do contribuinte #%d: \n", i);
			System.out.print("Pessoa física ou jurídica [f/j]? ");
			char ch = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine(); // Limpa o buffer de entrada. (Consome a quebra de linha anterior pendente)
			String nome = sc.nextLine();
			System.out.print("Renda anual: R$ ");
			Double rendaAnual= sc.nextDouble();
			
			if (ch == 'f') {
				System.out.print("Gastos com Saúde: R$ ");
				Double gastosComSaude = sc.nextDouble();
				list.add(new PessoaFisica(nome, rendaAnual, gastosComSaude));
			}
			else if (ch == 'j') {
				System.out.print("Número de funcionáros: ");
				int numeroDeFuncionarios = sc.nextInt();
				list.add(new PessoaJuridica(nome, rendaAnual, numeroDeFuncionarios));
			}
			
		}	
		
		Double soma = 0.0;
		System.out.println();
		System.out.println("IMPOSTOS PAGOS:");
		for(Contribuinte contri : list) {
			Double arrecadado = contri.impostoAPagar();
			System.out.println(contri.getNome() + " R$ " + String.format("%.2f", contri.impostoAPagar()));
			soma += arrecadado; // soma recebe soma + totalArrecadado.
		}
		
		System.out.println();
		System.out.printf("TOTAL ARRECADADO: R$ %.2f", soma);			
	}
}
