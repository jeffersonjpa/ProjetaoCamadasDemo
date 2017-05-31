package br.unipe.cc.mlpIII.bancario.fachada;

import java.util.List;

import br.unipe.cc.mlpIII.bancario.modelo.Conta;
import br.unipe.cc.mlpIII.bancario.modelo.ContaService;
import br.unipe.cc.mlpIII.bancario.modelo.Titular;
import br.unipe.cc.mlpIII.bancario.modelo.TitularService;

/**
 * Classe fachada de comunicação entre a interface gráfica (UI) e a camada do modelo.
 * Essa classa possui todos os métodos que podem ser utilizados pelos usuário da UI. 
 * Ex.: cadastrarTitular(), cadastrarConta(), listarTitular(), listarConta(), etc. 
 * 
 * @author jefferson
 *
 */
public class Bancario {
	
	private ContaService contaService;
	private TitularService titularService;
	
	
	public Bancario() {
		contaService = new ContaService();
		titularService = new TitularService();
	}
	
	/**
	 * Método utilizado para cadastrar uma conta corrente.
	 * @param contaCorrente
	 * @return 
	 */
	public boolean salvarConta(Conta contaCorrente) {
		return contaService.cadastrar(contaCorrente);
	}

	/**
	 * Método utilizado para atualizar uma conta corrente..
	 * @param contaCorrente
	 * @return 
	 */
	public boolean atualizarConta(Conta contaCorrente) {
		return contaService.atualizar(contaCorrente);
	}

	/**
	 * Método utilizado para deletar uma conta corrente..
	 * @param contaCorrente
	 * @return 
	 */
	public boolean deletarConta(Conta contaCorrente) {
		return contaService.deletar(contaCorrente);
	}

	/**
	 * Método utilizado para listar contas.
	 * @param contaCorrente
	 * @return 
	 */
	public List<Conta> listarConta() {
		return contaService.listar();
	}

	/**
	 * Método utilizado para cadastrar uma conta corrente.
	 * @param contaCorrente
	 * @return 
	 */
	public boolean salvarTitular(Titular titular) {
		return titularService.cadastrar(titular);
	}

	/**
	 * Método utilizado para atualizar uma conta corrente..
	 * @param contaCorrente
	 * @return 
	 */
	public boolean atualizarTitular(Titular titular) {
		return titularService.atualizar(titular);
	}

	/**
	 * Método utilizado para deletar uma conta corrente..
	 * @param contaCorrente
	 * @return 
	 */
	public boolean deletarTitular(Titular titular) {
		return titularService.deletar(titular);
	}

	/**
	 * Método utilizado para listar contas.
	 * @param contaCorrente
	 * @return 
	 */
	public List<Titular> listarTitular() {
		return titularService.listar();
	}

	/**
	 * Método responsável por fazer a validação do usuário e senha na base de dados. 
	 * @param user
	 * @param password
	 * @return
	 */
	public boolean login(String user, String password) {
//		TODO: Colocar aqui a validação de login e senha indo buscar essa informação na base de dados 
//		através de uma classe LoginService.
		if (user.equals("admin") && password.equals("123456"))
			return true;
		else
			return false;
	}

}
