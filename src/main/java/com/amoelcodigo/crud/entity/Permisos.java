package com.amoelcodigo.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Permisos")
public class Permisos {

	@Id
	@Column(name="id")
	private Integer id ;

	@Column(name="nombre")
	private String nombre ;

	@Column(name="admin")
	private String admin ;

	@Column(name="usuario_id")
	private Integer usuarioId ;

	public Permisos(){
		super();
	}

	public Integer getId(){
		return this.id;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public String getNombre(){
		return this.nombre;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public String getAdmin(){
		return this.admin;
	}

	public void setAdmin(String admin){
		this.admin = admin;
	}

	public Integer getUsuarioId(){
		return this.usuarioId;
	}

	public void setUsuarioId(Integer usuarioId){
		this.usuarioId = usuarioId;
	}

}