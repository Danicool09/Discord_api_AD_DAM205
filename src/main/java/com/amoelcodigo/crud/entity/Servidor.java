package com.amoelcodigo.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Servidor")
public class Servidor {

	@Id
	@Column(name="id")
	private Integer id ;

	@Column(name="nombre")
	private String nombre ;

	@Column(name="foto")
	private String foto ;

	@Column(name="usuario_id")
	private String usuarioId ;

	public Servidor(){
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

	public String getFoto(){
		return this.foto;
	}

	public void setFoto(String foto){
		this.foto = foto;
	}

	public String getUsuarioId(){
		return this.usuarioId;
	}

	public void setUsuarioId(String usuarioId){
		this.usuarioId = usuarioId;
	}

}