package controller;


import java.sql.ResultSet;

import bo.Tratamento;
import model.TratamentoDAO;

public class TratamentoController {
	
	public void create(Tratamento tratamento) 
	{
		TratamentoDAO model = new TratamentoDAO();
			model.create(tratamento);
	}
	public void delete(Tratamento tratamento) 
	{
		TratamentoDAO model = new TratamentoDAO();
			model.delete(tratamento);
	}
	
	public void update(Tratamento tratamento) 
	{
		TratamentoDAO model = new TratamentoDAO();
			model.update(tratamento);
	}
	
	public ResultSet read(Tratamento tratamento) 
	{
		TratamentoDAO model = new TratamentoDAO();
			
			return model.read(tratamento);
	}
}
