package controller;


import java.sql.ResultSet;

import bo.Paciente;
import model.PacienteDAO;

public class PacienteController {
	
	public void create(Paciente paciente) 
	{
			PacienteDAO model = new PacienteDAO();
			model.create(paciente);
	}
	public void delete(Paciente paciente) 
	{
		PacienteDAO model = new PacienteDAO();
			model.delete(paciente);
	}
	
	public void update(Paciente paciente) 
	{
		PacienteDAO model = new PacienteDAO();
			model.update(paciente);
	}
	
	public ResultSet read(Paciente paciente) 
	{
		PacienteDAO model = new PacienteDAO();
			
			return model.read(paciente);
	}
}
