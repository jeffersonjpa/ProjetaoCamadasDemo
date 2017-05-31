package br.unipe.cc.mlpIII.bancario.persistence;

import java.util.List;

import br.unipe.cc.mlpIII.bancario.modelo.Titular;

public interface ITitular {
	public boolean inserir(Titular titular);
	public List<Titular> listar();
	public boolean atualizar(Titular titular);
	public boolean deletar(Titular titular);

}
