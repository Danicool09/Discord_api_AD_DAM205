package com.amoelcodigo.crud.dao;

import com.amoelcodigo.crud.entity.Perfil;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilDao extends JpaRepository<Perfil, Integer>{

}