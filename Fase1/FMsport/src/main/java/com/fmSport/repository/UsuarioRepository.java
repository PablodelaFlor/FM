package com.fmSport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fmSport.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{

}
