package br.unipe.cc.mlpIII.bancario.modelo;

import java.util.List;

import br.unipe.cc.mlpIII.bancario.persistence.ITitular;

public class TitularService {
	private ITitular repositorioTitular;

	public boolean cadastrar(Titular titular) {
		return repositorioTitular.inserir(titular);
	}

	public boolean atualizar(Titular titular) {
		return repositorioTitular.atualizar(titular);
	}

	public boolean deletar(Titular titular) {
		return repositorioTitular.deletar(titular);
	}
	
	public List<Titular> listar() {
		return repositorioTitular.listar();
	}

	
	
}
