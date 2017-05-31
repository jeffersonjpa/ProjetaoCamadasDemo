package br.unipe.cc.mlpIII.bancario.modelo;

/**
 * Classe que representa uma conta no sistema bancário. Essa classe deve ter somente os métodos get e set.
 * As informações de como cadastrar, listar, deletar e fazer atualização de uma conta 
 * devem ficar na classe ContaService. 
 * 
 * @author jefferson
 * @date 20/05/2017
 * @vrsion 1.0
 *
 */
public class Conta {
	
	protected Long id;
	protected String numero;
	protected double saldo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	@Override
	public String toString() {
		return "Id: " + this.id + 
				"Numero: " + this.numero +
				"Saldo: "  + this.saldo;
	}
}
