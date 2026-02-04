package com.fmSport.services;

import java.util.List;

import com.fmSport.model.Servicio;

public interface ServicioService {

	Servicio crear(Servicio c);
	
	Servicio buscarPorId(Long id);

	List<Servicio> listar();

	Servicio actualizar(Long id, Servicio datos);

	boolean borrar(Long id);
	
	List<Servicio> listarActivos();
	
	 List<Servicio> porCategoria(String categoria);
	 
	 List<Servicio> buscarPorNombre(String texto);
}
