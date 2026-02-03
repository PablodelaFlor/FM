package com.fmSport.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fmSport.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva,Long>{

    List<Reserva> findByClienteId(Long clienteId);

    List<Reserva> findBySesionId(Long sesionId);

    List<Reserva> findByFechaReserva(LocalDate fecha);

    List<Reserva> findByEstado(String estado);
}
