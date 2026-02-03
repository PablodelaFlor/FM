package com.fmSport.services;

import java.util.List;

import com.fmSport.model.WodDetalle;

public interface WodDetalleService {
	WodDetalle crear(WodDetalle w);

	List<WodDetalle> listar();

	WodDetalle obtener(Long id);

	WodDetalle actualizar(Long id, WodDetalle datos);

	boolean borrar(Long id);
}
