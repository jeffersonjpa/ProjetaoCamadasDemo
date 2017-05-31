package br.unipe.cc.mlpIII.bancario.modelo;

/**
 * Classe que representa o titular de uma conta corrente no sistema bancário.
 * 
 * @author jefferson
 * @date 20/05/2017
 * @vrsion 1.0
 *
 */
public class Titular {
	
	private Long id;
	private String nome;
	private String matricula;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	@Override
	public String toString() {
		return "Id: " + this.id +
				"Nome: " + this.nome + 
				"Matricula: " + this.matricula;
	}
}
