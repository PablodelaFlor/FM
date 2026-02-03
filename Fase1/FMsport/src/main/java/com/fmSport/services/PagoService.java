package com.fmSport.services;

import java.util.List;

import com.fmSport.model.Pago;

public interface PagoService {
	Pago crear(Pago p);

	List<Pago> listar();
	
	Pago obtener(Long id);

	Pago actualizar(Long id, Pago datos);

	boolean borrar(Long id);
}
