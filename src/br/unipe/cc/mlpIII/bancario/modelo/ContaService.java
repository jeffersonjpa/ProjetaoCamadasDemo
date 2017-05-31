package br.unipe.cc.mlpIII.bancario.modelo;

import java.util.List;

import br.unipe.cc.mlpIII.bancario.persistence.IConta;
import br.unipe.cc.mlpIII.bancario.persistence.RepositorioContas;

/**
 * Classe do modelo que tem as funções de CRUD para uma conta.
 * @author jefferson
 *
 */
public class ContaService {
	
	private IConta repositorioConta;
	
	public ContaService() {
		repositorioConta = new RepositorioContas();
	}

	public boolean cadastrar(Conta contaCorrente) {
		return repositorioConta.inserir(contaCorrente);
	}

	public List<Conta> listar() {
		return repositorioConta.listar();
	}

	public boolean atualizar(Conta contaCorrente) {
		return repositorioConta.atualizar(contaCorrente);
	}

	public boolean deletar(Conta contaCorrente) {
		return repositorioConta.deletar(contaCorrente);
	}

}
