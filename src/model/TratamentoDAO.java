package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import bo.Tratamento;
import jdbc.*;

public class TratamentoDAO {
	
	public void create(Tratamento tratamento)
	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "insert into tratamento(codigo, nome, valor) values (?, ?, ?)";
		
		try
		{
			stmt = con.prepareStatement(sql);  //instancia uma instrucao sql
			stmt.setString(1, tratamento.getCodigo()); //primeiro parametro da query
			stmt.setString(2, tratamento.getNome());
			stmt.setString(3, (tratamento.getValor()+""));
			stmt.executeUpdate();
			System.out.println("[TratamentoDao] tratamento incluido com sucesso");
			
			
		} catch (SQLException e)
		{
			System.out.println("Erro na tentativa de insercao: "+ e.getMessage());
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}
	
	public void delete(Tratamento tratamento)
	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "delete from tratamento where codigo = ?";
		
		
		try
		{
			stmt = con.prepareStatement(sql);  //instancia uma instrucao sql
			stmt.setString(1, tratamento.getCodigo()); //primeiro parametro da query
			
			stmt.executeUpdate();
			System.out.println("[TratamentoDAO] Tratamento excluido com sucesso");
			
			
		} catch (SQLException e)
		{
			System.out.println("Erro na tentativa de insercao: 2"+ e.getMessage());
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}
	
	public void update(Tratamento tratamento)
	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "update tratamento set codigo=? , nome=? , valor=? where codigo=?";
		
		
		try
		{
			stmt = con.prepareStatement(sql);  //instancia uma instrucao sql
			stmt.setString(1, tratamento.getCodigo()); //primeiro parametro da query
			stmt.setString(2, tratamento.getNome());
			stmt.setString(3, (""+tratamento.getValor()));
			stmt.setString(4, tratamento.getCodigo());
			
			stmt.executeUpdate();
			System.out.println("[TratamentoDAO] Tratamento alterado com sucesso");
			
			
		} catch (SQLException e)
		{
			System.out.println("Erro na tentativa de insercao: 2"+ e.getMessage());
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}
	
	public ResultSet read(Tratamento tratamento)
	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		 String nome;
		
		String sql = "select nome,valor,codigo from tratamento where nome like ?";
		
		
		try
		{
			stmt = con.prepareStatement(sql);  //instancia uma instrucao sql
			nome=("%" + tratamento.getNome() + "%");
			stmt.setString(1, nome); //primeiro parametro da query
			
			System.out.println(stmt);
			
			ResultSet rs = stmt.executeQuery();
			
			return rs;
//			
//			while(rs.next()){
//				System.out.println("*********************************");
//				System.out.println("Cpf : " + rs.getString("cpf"));
//				System.out.println("Nome : " + rs.getString("nome"));
//				System.out.println("Email : " + rs.getString("email"));
//				System.out.println("*********************************");
//			}
//			

		
			
			
			
		} catch (SQLException e)
		{
			System.out.println("entrou aqui");
			System.out.println("Erro na tentativa de insercao: 2"+ e.getMessage());
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return null;
		
	}

}