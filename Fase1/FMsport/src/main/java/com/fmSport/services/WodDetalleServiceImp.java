package com.fmSport.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmSport.model.WodDetalle;
import com.fmSport.repository.WodDetalleRepository;

@Service
public class WodDetalleServiceImp implements WodDetalleService {

	@Autowired
	private WodDetalleRepository wdr;

	@Override
	public WodDetalle crear(WodDetalle w) {
		return wdr.save(w);
	}

	@Override
	public List<WodDetalle> listar() {
		return wdr.findAll();
	}

	@Override
	public WodDetalle obtener(Long id) {
		return wdr.findById(id).orElse(null);
	}

	@Override
	public WodDetalle actualizar(Long id, WodDetalle datos) {
		WodDetalle w = obtener(id);

		if (w == null) {
			return null;
		}

		w.setSesion(datos.getSesion());
		w.setTitulo(datos.getTitulo());
		w.setDescripcion(datos.getDescripcion());
		w.setObjetivoDia(datos.getObjetivoDia());
		w.setEjercicios(datos.getEjercicios());

		return wdr.save(w);
	}

	@Override
	public boolean borrar(Long id) {
		if (!wdr.existsById(id)) {
			return false;
		} else {
			wdr.deleteById(id);
			return true;
		}

	}
}