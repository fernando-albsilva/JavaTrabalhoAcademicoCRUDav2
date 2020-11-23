package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import bo.Paciente;
import jdbc.*;

public class PacienteDAO {
	
	public void create(Paciente paciente)
	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "insert into paciente(cpf, nome, email) values (?, ?, ?)";
		
		try
		{
			stmt = con.prepareStatement(sql);  //instancia uma instrucao sql
			stmt.setString(1, paciente.getCpf()); //primeiro parametro da query
			stmt.setString(2, paciente.getNome());
			stmt.setString(3, paciente.getEmail());
			stmt.executeUpdate();
			System.out.println("[PacienteDao] Paciente incluido com sucesso");
			
			
		} catch (SQLException e)
		{
			System.out.println("Erro na tentativa de insercao: "+ e.getMessage());
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}
	
	public void delete(Paciente paciente)
	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "delete from paciente where cpf = ?";
		
		
		try
		{
			stmt = con.prepareStatement(sql);  //instancia uma instrucao sql
			stmt.setString(1, paciente.getCpf()); //primeiro parametro da query
			
			stmt.executeUpdate();
			System.out.println("[PAcienteDAO] Paciente excluido com sucesso");
			
			
		} catch (SQLException e)
		{
			System.out.println("Erro na tentativa de insercao: 2"+ e.getMessage());
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}
	
	public void update(Paciente paciente)
	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "update paciente set cpf=? , nome=? , email=? where cpf=?";
		
		
		try
		{
			stmt = con.prepareStatement(sql);  //instancia uma instrucao sql
			stmt.setString(1, paciente.getCpf()); //primeiro parametro da query
			stmt.setString(2, paciente.getNome());
			stmt.setString(3, paciente.getEmail());
			stmt.setString(4, paciente.getCpf());
			
			stmt.executeUpdate();
			System.out.println("[PacienteDAO] Paciente alterado com sucesso");
			
			
		} catch (SQLException e)
		{
			System.out.println("Erro na tentativa de insercao: 2"+ e.getMessage());
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}
	
	public ResultSet read(Paciente paciente)
	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		 String nome;
		
		String sql = "select cpf,nome,email from paciente where nome like ?";
		
		
		try
		{
			stmt = con.prepareStatement(sql);  //instancia uma instrucao sql
			nome=("%" + paciente.getNome() + "%");
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