package br.unipe.cc.mlpIII.bancario.modelo;

/**
 * Classe que representa uma Conta Corrente no sistema bancário.
 * @author jefferson <jeffersonjpa@gmail.com>
 *
 */
public class ContaCorrente extends Conta {
	
	/**
	 * Construtor da classe ContaCorrente.
	 * @param numero
	 * @param saldo
	 */
	public ContaCorrente(String numero, double saldo) {
		this.numero = numero;
		this.saldo = saldo;
	}
	
	/**
	 * Método creditar da classe Conta Corrente.
	 * @param valor
	 */
	public void creditar(double valor) {
		if (valor > 0) {
			this.saldo = this.saldo + valor;
		} else {
//			dispara uma exceção 
			System.out.println("Valor negativo não permitidos");
		}
	}
	
	/**
	 * Método debitar da classe Conta Corrente.
	 * @param valor
	 */
	public void debitar(double valor) {
		if (valor > this.saldo) {
			this.saldo = this.saldo - valor;
		} else {
//			Dispara uma exceção saldo insuficiente exception
			System.out.println("Saldo insuficiente.");
		}
	}
}
