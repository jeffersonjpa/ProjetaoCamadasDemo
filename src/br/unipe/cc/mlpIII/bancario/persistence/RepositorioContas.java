package br.unipe.cc.mlpIII.bancario.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.unipe.cc.mlpIII.bancario.modelo.Conta;

/**
 * Classe de conexão com o banco de dados.
 * 
 * @author jefferson
 * @date 20/05/2017
 * @version 1.0
 *
 */
public class RepositorioContas implements IConta {
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	/**
	 * Método que estabelece uma conexão com o banco de dados.
	 * @return conexão com o banco de dados.
	 * @throws ClassNotFoundException
	 */
	public Connection getConnection() throws ClassNotFoundException {
		
		try {
			System.out.println("--- Carregamento do Driver JDBC ---");

			Class.forName("org.postgresql.Driver");
			
			System.out.println("--- Driver JDBC carregado com sucesso R---");
			
//			TODO: Colocar esse parâmetros no arquivo database.properties
			String url = "jdbc:postgresql://localhost:5432/bancario";
			String user = "computacao";
			String password = "123456";
			
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("--- Conexao estabelecida com sucesso ---");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	/**
	 * Método utilizado para listar todas as contas do banco.
	 */
	public List<Conta> listar() {
		
		List<Conta>	contas = new ArrayList<Conta>();
		
		try {
			conn = getConnection();
			
			stmt = conn.createStatement();
			
			System.out.println("--- Statement criado com sucesso ---");
			
//			String sql = "SELECT * FROM conta";
			String sql = "SELECT id, numero, saldo FROM conta";
			
			rs = stmt.executeQuery(sql);
			
			System.out.println("--- Query realizada com sucesso ---");
			
			while(rs.next()) {
				
//				Criar um objeto conta
				Conta conta = new Conta();
				
//				1º forma de acesso com parâmetros string
//				representando os nomes das colunas
				Long id = rs.getLong("id");
				String numero = rs.getString("numero");
				double saldo = rs.getDouble("saldo");
				
//				2º forma de acesso com parâmetros inteiros
//				Long id = rs.getLong(1);
//				String numero = rs.getString(2);
//				double saldo = rs.getDouble(3);
				
				conta.setId(id);
				conta.setNumero(numero);
				conta.setSaldo(saldo);
				
				contas.add(conta);
				System.out.println(conta);
			}
//			Fechamento das conexões com o banco
			close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
//		Retorna uma coleção de objetos conta
		return contas;
	}

	@Override
	public boolean inserir(Conta conta) {
		
		boolean resultado = false;
		
		try {
			conn = getConnection();
			
			stmt = conn.createStatement();
			
			String sql = "INSERT INTO conta(numero, saldo) " +
						 "VALUES ('"+ conta.getNumero() + "'," 
								+  conta.getSaldo() + ");";
			
			System.out.println(sql);
			
			int linhas = stmt.executeUpdate(sql);
			
			if (linhas != 0)
				resultado = true; //significa que pelo menos 1 linhas foi afetada pelo comando.
			
			close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		se chegou até esse ponto tudo correu bem, então returno true.
		return resultado;
	}

	@Override
	public boolean atualizar(Conta conta) {
		return false;
	}

	@Override
	public boolean deletar(Conta conta) {
		return false;		
	}
	
	/**
	 * Método utilizado para fechar as conexões com o banco.
	 */
	public void close() {
		try {
			if (conn != null)
				conn.close();
			if (stmt != null)
				stmt.close();
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}