package com.amoelcodigo.crud.dao;

import com.amoelcodigo.crud.entity.Mensajes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensajesDao extends JpaRepository<Mensajes, Integer>{

}