package br.unipe.cc.mlpIII.bancario.ui;

import br.unipe.cc.mlpIII.bancario.fachada.Bancario;
import br.unipe.cc.mlpIII.bancario.modelo.Conta;
import br.unipe.cc.mlpIII.bancario.modelo.ContaCorrente;

public class PrincipalSemSwing {
	
	public static void main(String[] args) {
		
		Conta contaCorrente = new ContaCorrente("1012124-X", 15000.00);
		Bancario bancario = new Bancario();
		boolean salved = bancario.salvarConta(contaCorrente);
		
		if (salved) {
			System.out.println("Objeto Conta salvo com sucesso.");
		} else {
			System.out.println("Dispara uma exceção: ContaNãoSalvaException.");
		}
	}
}
