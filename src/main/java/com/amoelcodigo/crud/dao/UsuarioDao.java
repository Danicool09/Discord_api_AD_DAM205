package com.amoelcodigo.crud.dao;

import com.amoelcodigo.crud.entity.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Integer>{

}