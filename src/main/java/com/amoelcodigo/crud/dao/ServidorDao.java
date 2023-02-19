package com.amoelcodigo.crud.dao;

import com.amoelcodigo.crud.entity.Servidor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServidorDao extends JpaRepository<Servidor, Integer>{

}