package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import bo.Consulta;
import jdbc.*;

public class ConsultaDAO {
	
	public void create(Consulta consulta)
	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "insert into consulta(codigo, fk_paciente_cpf, fk_tratamento_codigo , descricao) values (?, ?, ?, ?)";
		
		try
		{
			stmt = con.prepareStatement(sql);  //instancia uma instrucao sql
			stmt.setString(1, consulta.getCodigo()); //primeiro parametro da query
			stmt.setString(2, consulta.getPacienteCpf());
			stmt.setString(3, consulta.getTratamentoCodigo());
			stmt.setString(4, consulta.getDescricao());
			stmt.executeUpdate();
			System.out.println("[ConsultaDao] Consulta incluida com sucesso");
			
			
		} catch (SQLException e)
		{
			System.out.println("Erro na tentativa de insercao: "+ e.getMessage());
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}
	
	public void delete(Consulta consulta)
	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "delete from consulta where codigo = ?";
		
		
		try
		{
			stmt = con.prepareStatement(sql);  //instancia uma instrucao sql
			stmt.setString(1, consulta.getCodigo()); //primeiro parametro da query
			
			stmt.executeUpdate();
			System.out.println("[ConsultaDAO] Consulta excluida com sucesso");
			
			
		} catch (SQLException e)
		{
			System.out.println("Erro na tentativa de insercao: 2"+ e.getMessage());
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}
	
	public void update(Consulta consulta)
	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql = "update consulta set codigo=? , fk_paciente_cpf=? ,fk_tratamento_codigo=? , descricao=? where codigo=?";
		
		
		try
		{
			stmt = con.prepareStatement(sql);  //instancia uma instrucao sql
			stmt.setString(1, consulta.getCodigo()); //primeiro parametro da query
			stmt.setString(2, consulta.getPacienteCpf());
			stmt.setString(3, consulta.getTratamentoCodigo());
			stmt.setString(4, consulta.getDescricao());
			stmt.setString(5, consulta.getCodigo());
			
			stmt.executeUpdate();
			System.out.println("[ConsultaDao] Consulta alterada com sucesso");
			
			
		} catch (SQLException e)
		{
			System.out.println("Erro na tentativa de insercao: 2"+ e.getMessage());
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}
	
	public ResultSet read(Consulta consulta)
	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		 String nome;
		
		String sql = "select codigo, fk_paciente_cpf, fk_tratamento_codigo , descricao from consulta where codigo like ?";
		
		
		try
		{
			stmt = con.prepareStatement(sql);  //instancia uma instrucao sql
			nome=("%" + consulta.getCodigo() + "%");
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