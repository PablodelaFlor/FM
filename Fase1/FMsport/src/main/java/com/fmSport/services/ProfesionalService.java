package com.fmSport.services;

import java.util.List;

import com.fmSport.model.Profesional;

public interface ProfesionalService {


	Profesional crear(Profesional c);
	
	List<Profesional> listar();
	
	Profesional actualizar(Long id,Profesional datos);
	
	boolean borrar(Long id);
}
