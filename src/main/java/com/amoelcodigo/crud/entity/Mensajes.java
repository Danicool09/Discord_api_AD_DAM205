package com.amoelcodigo.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Mensajes")
public class Mensajes {

	@Id
	@Column(name="id")
	private Integer id ;

	@Column(name="mensaje")
	private String mensaje ;

	@Column(name="usuario_id")
	private Integer usuarioId ;

	public Mensajes(){
		super();
	}

	public Integer getId(){
		return this.id;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public String getMensaje(){
		return this.mensaje;
	}

	public void setMensaje(String mensaje){
		this.mensaje = mensaje;
	}

	public Integer getUsuarioId(){
		return this.usuarioId;
	}

	public void setUsuarioId(Integer usuarioId){
		this.usuarioId = usuarioId;
	}

}