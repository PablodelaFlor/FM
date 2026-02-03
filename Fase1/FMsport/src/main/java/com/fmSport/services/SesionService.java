package com.fmSport.services;

import java.util.List;

import com.fmSport.model.Sesion;

public interface SesionService {
	Sesion crear(Sesion c);

	List<Sesion> listar();

	Sesion actualizar(Long id, Sesion datos);

	boolean borrar(Long id);
}
