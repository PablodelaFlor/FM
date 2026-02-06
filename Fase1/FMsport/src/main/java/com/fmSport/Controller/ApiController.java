package com.fmSport.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fmSport.model.Reserva;
import com.fmSport.model.Servicio;
import com.fmSport.model.Sesion;
import com.fmSport.services.ReservaService;
import com.fmSport.services.ServicioService;
import com.fmSport.services.SesionService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ApiController {

	// ====== SERVICES ======
	@Autowired
	private ServicioService ss;

	@Autowired
	private SesionService ses;

	@Autowired
	private ReservaService rs;

	// ======================= SERVICIO =========================

	@GetMapping("/servicios")
	public ResponseEntity<List<Servicio>> listarServicios() {
		return ResponseEntity.ok(ss.listar());
	}

	@GetMapping("/servicios/{id}")
	public ResponseEntity<Servicio> obtenerServicio(@PathVariable Long id) {
		Servicio s = ss.buscarPorId(id);

		if (s == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(s);
		}
	}

	@PostMapping("/servicios")
	public ResponseEntity<Servicio> crearServicio(@RequestBody Servicio s) {
		return ResponseEntity.ok(ss.crear(s));
	}

	@PutMapping("/servicios/{id}")
	public ResponseEntity<Servicio> actualizarServicio(@PathVariable Long id, @RequestBody Servicio datos) {
		Servicio s = ss.actualizar(id, datos);

		if (s == null) {
			return ResponseEntity.notFound().build();
		} else {

			return ResponseEntity.ok(s);
		}
	}

	@DeleteMapping("/servicios/{id}")
	public ResponseEntity<Void> borrarServicio(@PathVariable Long id) {
		boolean ok = ss.borrar(id);

		if (!ok) {
			return ResponseEntity.notFound().build();
		} else {

			return ResponseEntity.noContent().build();
		}
	}

	// Extras Servicio
	@GetMapping("/servicios/activos")
	public ResponseEntity<List<Servicio>> serviciosActivos() {
		return ResponseEntity.ok(ss.listarActivos());
	}

	@GetMapping("/servicios/categoria/{categoria}")
	public ResponseEntity<List<Servicio>> serviciosPorCategoria(@PathVariable String categoria) {
		return ResponseEntity.ok(ss.porCategoria(categoria));
	}

	@GetMapping("/servicios/buscar/{texto}")
	public ResponseEntity<List<Servicio>> buscarServicios(@PathVariable String texto) {
		return ResponseEntity.ok(ss.buscarPorNombre(texto));
	}

	// ======================== SESION ==========================

	@GetMapping("/sesiones")
	public ResponseEntity<List<Sesion>> listarSesiones() {
		return ResponseEntity.ok(ses.listar());
	}

	@GetMapping("/sesiones/{id}")
	public ResponseEntity<Sesion> obtenerSesion(@PathVariable Long id) {
		Sesion s = ses.obtener(id);

		if (s == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(s);
	}

	@PostMapping("/sesiones")
	public ResponseEntity<Sesion> crearSesion(@RequestBody Sesion s) {
		return ResponseEntity.ok(ses.crear(s));
	}

	@PutMapping("/sesiones/{id}")
	public ResponseEntity<Sesion> actualizarSesion(@PathVariable Long id, @RequestBody Sesion datos) {
		Sesion s = ses.actualizar(id, datos);

		if (s == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(s);
	}

	@DeleteMapping("/sesiones/{id}")
	public ResponseEntity<Void> borrarSesion(@PathVariable Long id) {
		boolean ok = ses.borrar(id);

		if (!ok) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.noContent().build();
	}

	// Extras Sesion (los útiles)
	@GetMapping("/sesiones/estado/{estado}")
	public ResponseEntity<List<Sesion>> sesionesPorEstado(@PathVariable String estado) {
		return ResponseEntity.ok(ses.porEstado(estado));
	}

	@GetMapping("/sesiones/profesional/{profesionalId}")
	public ResponseEntity<List<Sesion>> sesionesPorProfesional(@PathVariable Long profesionalId) {
		return ResponseEntity.ok(ses.porProfesional(profesionalId));
	}

	@GetMapping("/sesiones/categoria/{categoria}")
	public ResponseEntity<List<Sesion>> sesionesPorCategoria(@PathVariable String categoria) {
		return ResponseEntity.ok(ses.porCategoriaServicio(categoria));
	}

	// Fecha por query param: /api/sesiones/fecha?fecha=2026-02-04
	@GetMapping("/sesiones/fecha")
	public ResponseEntity<List<Sesion>> sesionesPorFecha(@RequestParam String fecha) {
		LocalDate f = LocalDate.parse(fecha);
		return ResponseEntity.ok(ses.porFecha(f));
	}

	@PutMapping("/sesiones/{id}/estado/{estado}")
	public ResponseEntity<Sesion> cambiarEstadoSesion(@PathVariable Long id, @PathVariable String estado) {
		Sesion s = ses.cambiarEstado(id, estado);

		if (s == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(s);
	}

	// ======================== RESERVA =========================

	@GetMapping("/reservas")
	public ResponseEntity<List<Reserva>> listarReservas() {
		return ResponseEntity.ok(rs.listar());
	}

	@GetMapping("/reservas/{id}")
	public ResponseEntity<Reserva> obtenerReserva(@PathVariable Long id) {
		Reserva r = rs.obtener(id);

		if (r == null) {
			return ResponseEntity.notFound().build();
		} else {

			return ResponseEntity.ok(r);
		}
	}

	@PostMapping("/reservas")
	public ResponseEntity<Reserva> crearReserva(@RequestBody Reserva r) {
		return ResponseEntity.ok(rs.crear(r));
	}

	@PutMapping("/reservas/{id}")
	public ResponseEntity<Reserva> actualizarReserva(@PathVariable Long id, @RequestBody Reserva datos) {
		Reserva r = rs.actualizar(id, datos);

		if (r == null) {
			return ResponseEntity.notFound().build();
		} else {

			return ResponseEntity.ok(r);
		}
	}

	@DeleteMapping("/reservas/{id}")
	public ResponseEntity<Void> borrarReserva(@PathVariable Long id) {
		boolean ok = rs.borrar(id);

		if (!ok) {
			return ResponseEntity.notFound().build();
		} else {

			return ResponseEntity.noContent().build();
		}
	}

	// Extras Reserva
	@GetMapping("/reservas/cliente/{clienteId}")
	public ResponseEntity<List<Reserva>> reservasPorCliente(@PathVariable Long clienteId) {
		return ResponseEntity.ok(rs.porCliente(clienteId));
	}

	@GetMapping("/reservas/sesion/{sesionId}")
	public ResponseEntity<List<Reserva>> reservasPorSesion(@PathVariable Long sesionId) {
		return ResponseEntity.ok(rs.porSesion(sesionId));
	}

	@PutMapping("/reservas/{id}/cancelar")
	public ResponseEntity<Reserva> cancelarReserva(@PathVariable Long id) {
		Reserva r = rs.cancelar(id);

		if (r == null) {
			return ResponseEntity.notFound().build();
		} else {

			return ResponseEntity.ok(r);
		}
	}
}
