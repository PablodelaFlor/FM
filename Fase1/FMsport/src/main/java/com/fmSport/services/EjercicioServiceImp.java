package com.fmSport.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmSport.model.Ejercicio;
import com.fmSport.repository.EjercicioRepository;

@Service
public class EjercicioServiceImp implements EjercicioService {

	@Autowired
	private EjercicioRepository er;

	@Override
	public Ejercicio crear(Ejercicio e) {
		return er.save(e);
	}

	@Override
	public List<Ejercicio> listar() {
		return er.findAll();
	}

	@Override
	public Ejercicio obtener(Long id) {
		return er.findById(id).orElse(null);
	}

	@Override
	public Ejercicio actualizar(Long id, Ejercicio datos) {
		Ejercicio e = obtener(id);

		if (e == null) {
			return null;
		}

		e.setNombre(datos.getNombre());
		e.setCategoria(datos.getCategoria());
		e.setDescripcion(datos.getDescripcion());
		e.setMaterial(datos.getMaterial());

		return er.save(e);
	}

	@Override
	public boolean borrar(Long id) {
		if (!er.existsById(id)) {
			return false;
		}

		er.deleteById(id);
		return true;
	}
}
