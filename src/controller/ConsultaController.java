package controller;


import java.sql.ResultSet;

import bo.Consulta;
import model.ConsultaDAO;

public class ConsultaController {
	
	public void create(Consulta consulta) 
	{
		ConsultaDAO model = new ConsultaDAO();
			model.create(consulta);
	}
	public void delete(Consulta consulta) 
	{
		ConsultaDAO model = new ConsultaDAO();
			model.delete(consulta);
	}
	
	public void update(Consulta consulta) 
	{
		ConsultaDAO model = new ConsultaDAO();
			model.update(consulta);
	}
	
	public ResultSet read(Consulta consulta) 
	{
		ConsultaDAO model = new ConsultaDAO();
			
			return model.read(consulta);
	}
}
