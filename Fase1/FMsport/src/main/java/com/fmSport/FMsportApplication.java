package com.fmSport;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fmSport.model.Cliente;
import com.fmSport.model.Reserva;
import com.fmSport.model.Servicio;
import com.fmSport.model.Sesion;
import com.fmSport.repository.ClienteRepository;
import com.fmSport.repository.ReservaRepository;
import com.fmSport.repository.ServicioRepository;
import com.fmSport.repository.SesionRepository;

@SpringBootApplication
public class FMsportApplication  implements CommandLineRunner {
	   @Autowired
	    private ServicioRepository sr;

	    @Autowired
	    private SesionRepository sesr;

	    @Autowired
	    private ClienteRepository cr;

	    @Autowired
	    private ReservaRepository rr;
	 
	public static void main(String[] args) {
		SpringApplication.run(FMsportApplication.class, args);
	
	}

	@Override
	public void run(String... args) throws Exception {
		
		   Servicio personal = new Servicio();
	        personal.setNombre("Entrenamiento Personal");
	        personal.setCategoria("PERSONAL");
	        personal.setDuracionMin(60);
	        personal.setPrecioBase(30);
	        personal.setDescripcion("Entrenamiento individual adaptado.");
	        personal.setActivo(true);

	        Servicio grupal = new Servicio();
	        grupal.setNombre("Clase Grupal CrossFit");
	        grupal.setCategoria("GRUPAL");
	        grupal.setDuracionMin(60);
	        grupal.setPrecioBase(10);
	        grupal.setDescripcion("Sesión grupal con plazas limitadas.");
	        grupal.setActivo(true);

	        Servicio fisio = new Servicio();
	        fisio.setNombre("Fisioterapia Deportiva");
	        fisio.setCategoria("FISIO");
	        fisio.setDuracionMin(45);
	        fisio.setPrecioBase(25);
	        fisio.setDescripcion("Tratamiento y recuperación.");
	        fisio.setActivo(true);

	        sr.save(personal);
	        sr.save(grupal);
	        sr.save(fisio);

	        // ===== SESIONES =====
	        Sesion s1 = new Sesion();
	        s1.setServicio(personal);
	        s1.setFecha(LocalDate.now().plusDays(1));
	        s1.setCupoMax(1);
	        s1.setSala("Sala 1");
	        s1.setEstado("ABIERTA");
	        s1.setNotasInternas("Sesión individual");

	        Sesion s2 = new Sesion();
	        s2.setServicio(grupal);
	        s2.setFecha(LocalDate.now().plusDays(2));
	        s2.setCupoMax(10);
	        s2.setSala("Box Principal");
	        s2.setEstado("ABIERTA");
	        s2.setNotasInternas("Clase WOD");

	        Sesion s3 = new Sesion();
	        s3.setServicio(fisio);
	        s3.setFecha(LocalDate.now().plusDays(3));
	        s3.setCupoMax(1);
	        s3.setSala("Fisio");
	        s3.setEstado("ABIERTA");
	        s3.setNotasInternas("Sesión de fisioterapia");

	        sesr.save(s1);
	        sesr.save(s2);
	        sesr.save(s3);

	        // ===== CLIENTES =====
	        Cliente c1 = new Cliente();
	        c1.setNombre("Juan Pérez");
	        c1.setEmail("juan@mail.com");
	        c1.setLesiones("Ninguna");
	        c1.setFechaNacimiento(LocalDate.of(1990, 10, 25));
	        c1.setObservaciones("Buen desarrollo");
	        
	        Cliente c2 = new Cliente();
	        c2.setNombre("María López");
	        c2.setEmail("maria@mail.com");
	        c2.setLesiones("Lesion grado 2");
	        c2.setFechaNacimiento(LocalDate.of(1985, 2, 15));
	        c2.setObservaciones("Lesionada");
	        
	        cr.save(c1);
	        cr.save(c2);

	        // ===== RESERVAS =====
	        Reserva r1 = new Reserva();
	        r1.setCliente(c1);
	        r1.setSesion(s1);
	        r1.setFechaReserva(LocalDate.now());
	        r1.setEstado("CONFIRMADA");
	        r1.setComentarioCliente("Primera sesión");

	        Reserva r2 = new Reserva();
	        r2.setCliente(c2);
	        r2.setSesion(s2);
	        r2.setFechaReserva(LocalDate.now());
	        r2.setEstado("CONFIRMADA");
	        r2.setComentarioCliente("Clase grupal");

	        rr.save(r1);
	        rr.save(r2);
	
		
	}

}
