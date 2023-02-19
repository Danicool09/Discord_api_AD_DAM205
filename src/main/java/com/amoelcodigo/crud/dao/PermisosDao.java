package com.amoelcodigo.crud.dao;

import com.amoelcodigo.crud.entity.Permisos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermisosDao extends JpaRepository<Permisos, Integer>{

}