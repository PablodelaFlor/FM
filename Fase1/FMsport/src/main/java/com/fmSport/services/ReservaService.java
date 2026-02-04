package com.fmSport.services;

import java.time.LocalDate;
import java.util.List;

import com.fmSport.model.Reserva;

public interface ReservaService {

	Reserva crear(Reserva r);
	
	List<Reserva> listar();
	
	Reserva actualizar(Long id,Reserva datos);
	
	boolean borrar(Long id);
	
	public Reserva obtener(Long id);
	
	List<Reserva> porCliente(Long clienteId);
	
	List<Reserva> porSesion(Long sesionId);
	
	Reserva cancelar(Long id);
	
	List<Reserva> porFecha(LocalDate fecha);
}
