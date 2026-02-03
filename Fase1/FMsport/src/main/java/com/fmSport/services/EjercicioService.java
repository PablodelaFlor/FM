package com.fmSport.services;

import java.util.List;

import com.fmSport.model.Ejercicio;

public interface EjercicioService {
	Ejercicio crear(Ejercicio e);

	List<Ejercicio> listar();

	Ejercicio obtener(Long id);

	Ejercicio actualizar(Long id, Ejercicio datos);

	boolean borrar(Long id);
}
