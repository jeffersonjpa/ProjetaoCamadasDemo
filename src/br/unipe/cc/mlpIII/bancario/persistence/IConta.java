package br.unipe.cc.mlpIII.bancario.persistence;

import java.util.List;

import br.unipe.cc.mlpIII.bancario.modelo.Conta;

public interface IConta {
	
	public boolean inserir(Conta conta);
	public List<Conta> listar();
	public boolean atualizar(Conta conta);
	public boolean deletar(Conta conta);
}
