package com.fmSport.services;

import java.util.List;

import com.fmSport.model.Usuario;

public interface UsuarioService {
	Usuario crear(Usuario u);

	List<Usuario> listar();

	Usuario actualizar(Long id, Usuario datos);

	boolean borrar(Long id);
}
