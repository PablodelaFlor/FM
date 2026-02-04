package com.fmSport.services;

import java.time.LocalDate;
import java.util.List;

import com.fmSport.model.Sesion;

public interface SesionService {
	Sesion crear(Sesion c);

	List<Sesion> listar();

	Sesion actualizar(Long id, Sesion datos);
	
	Sesion obtener(Long id);

	boolean borrar(Long id);
	
	public List<Sesion> porEstado(String estado);
	
	List<Sesion> porProfesional(Long profesionalId);
	
	List<Sesion> porCategoriaServicio(String categoria);
	
	List<Sesion> porFecha(LocalDate fecha);
	
	Sesion cambiarEstado(Long id, String estado);
}
