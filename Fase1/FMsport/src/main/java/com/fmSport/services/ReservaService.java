package com.fmSport.services;

import java.util.List;

import com.fmSport.model.Reserva;

public interface ReservaService {

	Reserva crear(Reserva r);
	
	List<Reserva> listar();
	
	Reserva actualizar(Long id,Reserva datos);
	
	boolean borrar(Long id);
}
